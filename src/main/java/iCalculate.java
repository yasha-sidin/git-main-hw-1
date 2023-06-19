public interface iCalculate<T> {
  private T firstNum;
  private T secondNum;
  
  public T multiplication();

  public T sum();

  public T division();

  public T getFirstNumber();

  public T getSecondNumber();
}
