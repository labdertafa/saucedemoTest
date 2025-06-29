package util;

public class JsonLocator {
    private String getFieldBy;
    private String valueToFind;

    public String getGetFieldBy() {
        return getFieldBy;
    }

    public void setGetFieldBy(String getFieldBy) {
        this.getFieldBy = getFieldBy;
    }

    public String getValueToFind() {
        return valueToFind;
    }

    public void setValueToFind(String valueToFind) {
        this.valueToFind = valueToFind;
    }

    @Override
    public String toString() {
        return "JsonLocator{" +
                "getFieldBy='" + getFieldBy + '\'' +
                ", valueToFind='" + valueToFind + '\'' +
                '}';
    }
}