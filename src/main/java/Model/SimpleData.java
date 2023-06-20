package Model;

public class SimpleData extends Data <String> {
    private String data;
    @Override
    public String getData() {
        return data;
    }

    /**
     * Set new default String data
     *
     * @param data new default String data
     */
    public void setData(String data) {
        this.data = data;
    }
}
