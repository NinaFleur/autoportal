package client;

public enum ClientType {

    GC("gc"),
    SF("sf"),
    FF("ff"),
    IE("ie");

    private String clientName;

    ClientType(final String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return clientName;
    }
}
