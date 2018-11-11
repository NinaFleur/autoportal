package client;

public enum ClientType {

    GC("gc");

    private String clientName;

    ClientType(final String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return clientName;
    }
}
