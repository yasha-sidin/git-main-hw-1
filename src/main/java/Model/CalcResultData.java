package Model;

public class CalcResultData extends Data<String> {
    private String calcResultData;

    /**
     * CalcResultData constructor which init empty data
     */
    public CalcResultData() {
        this.calcResultData = "";
    }

    public String getData() {
        return calcResultData;
    }

    /**
     * Set new data in calculator format
     *
     * @param cn1       first ComplexNumber
     * @param cn2       second ComplexNumber
     * @param result    result ComplexNumber after operation under first and second ComplexNumber
     * @param activity  char of type of operation
     */
    public void setData(ComplexNumber cn1, ComplexNumber cn2, ComplexNumber result, char activity) {
        this.calcResultData = cn1.toString() + " " + activity + " " + cn2.toString() + " = " + result.toString();;
    }

}
