package pe.joedayz.jsonschemagenerator;

public class IfThen {

    private IfProperty ifProperty;
    private ThenProperty thenProperty;

    public IfThen() {
        this.ifProperty = new IfProperty();
        this.thenProperty = new ThenProperty();
    }

    public IfProperty getIfProperty() {
        return ifProperty;
    }

    public void setIfProperty(IfProperty ifProperty) {
        this.ifProperty = ifProperty;
    }

    public ThenProperty getThenProperty() {
        return thenProperty;
    }

    public void setThenProperty(ThenProperty thenProperty) {
        this.thenProperty = thenProperty;
    }
}
