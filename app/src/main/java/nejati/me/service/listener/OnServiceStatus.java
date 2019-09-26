package nejati.me.service.listener;

public interface OnServiceStatus<T> {

    /**
     * @param t the object when service have a response
     */
    void onReady(T t,int statusCode);

    /**
     * @param message  the message when service have an error
     */
    void onError(String message);
}
