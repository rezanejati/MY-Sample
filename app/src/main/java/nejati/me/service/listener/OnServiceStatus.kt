package nejati.me.service.listener

interface OnServiceStatus<T> {

    /**
     * @param t the object when service have a response
     */
    fun onReady(t: T)

    /**
     * @param message  the message when service have an error
     */
    fun onError(message: String)
}
