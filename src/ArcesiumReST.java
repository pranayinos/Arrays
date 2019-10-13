import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArcesiumReST {

    public static final String SECURITIES_URL = "http://api.myjson.com/bins/1eleys";
    public static final String PRICES_URL = "http://api.myjson.com/bins/vf9ac";

    public static void main(String[] args) {

        String date = "20190506";
        HttpRestClient httpRestClient = new HttpRestClient(new Gson());
        SecuritiesHeldResponse securitiesResponse =
                httpRestClient.get(SECURITIES_URL, SecuritiesHeldResponse.class);
        Set<Securities> listOfHeldSecurities = securitiesResponse.getData().stream()
                .filter(securities -> date.equals(securities.getDate()))
                .collect(Collectors.toSet());

//        System.out.println(securitiesResponse);

        PricesResponse pricesResponse =
                httpRestClient.get(PRICES_URL, PricesResponse.class);
        Map<String, Double> securityPrice = pricesResponse.getData().stream()
                .filter(prices -> date.equals(prices.getDate()))
                .collect(Collectors.toMap(o -> o.getSecurity(), o -> o.getPrice()));

        double totalPrice = listOfHeldSecurities.stream()
                .map(securities -> (securities.getQuantity()*securityPrice.get(securities.getSecurity())))
                .reduce((aDouble, aDouble2) -> aDouble+aDouble2).get();

  System.out.println(totalPrice);



    }
}

class HttpRestClient {

    private Gson gson;

    public HttpRestClient(Gson gson) {
        this.gson = gson;
    }

    public <RESPONSE> RESPONSE get(String URL, Class<RESPONSE> typrOfResponseClass) {

        try {
            String output = makeConnection(URL, "GET");
            return gson.fromJson(output, typrOfResponseClass);
        } catch (IOException e) {
            System.err.println("Failed rest call with message " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private String makeConnection(String urlString, String method) throws IOException {
        HttpURLConnection conn = null;
        BufferedReader in = null;
        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            if (conn.getResponseCode() != 200) {
                throw new IOException("Failed : HTTP " + method + " request to " + urlString + " error code : "
                        + conn.getResponseCode());
            }
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            if(in != null){
                in.close();
            }
        }
    }

}

class SecuritiesHeldResponse {
    private String totalRecords;
    private List<Securities> data;

    public String getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(String totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Securities> getData() {
        return data;
    }

    public void setData(List<Securities> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SecuritiesHeldResponse{" +
                "totalRecords='" + totalRecords + '\'' +
                ", data=" + data +
                '}';
    }
}

class Securities {
    private String date;
    private String security;
    private double quantity;
    private String portfolio;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Securities{" +
                "date='" + date + '\'' +
                ", security='" + security + '\'' +
                ", quantity=" + quantity +
                ", portfolio='" + portfolio + '\'' +
                '}';
    }
}

class Prices{
    private String date;
    private String security;
    private double price;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class PricesResponse {
    private String totalRecords;
    private List<Prices> data;

    public String getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(String totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Prices> getData() {
        return data;
    }

    public void setData(List<Prices> data) {
        this.data = data;
    }
}


//"totalRecords":15,"data":[{"date":"20190506","security":"ibm","quantity":100,"portfolio":"portfolio_1"},