public class Simbolo
{
    private String tipo;

    private boolean usado;

    public Simbolo(String tipo)
    {
        this.tipo = tipo;

        this.usado = false;
    }

    public String getTipo()
    {
        return tipo;
    }

    public boolean isUsado()
    {
        return usado;
    }

    public void setUsado(boolean usado)
    {
        this.usado = usado;
    }
}