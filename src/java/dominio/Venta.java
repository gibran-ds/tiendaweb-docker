package dominio;

public class Venta {
    private Integer id;
    private Float monto;
    private String sucursal;

    public Venta() {}

    public Venta(Integer id, Float monto, String sucursal) {
        this.id = id;
        this.monto = monto;
        this.sucursal = sucursal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }    
}
