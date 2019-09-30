package nejati.me.service.part

import java.util.ArrayList

import nejati.me.service.generator.ServiceGenerator
import nejati.me.service.listener.OnServiceStatus
import nejati.me.service.model.healthStatusModel.response.HealthStatusResponse
import nejati.me.service.model.questionsModel.response.QuestionsResponse

class HealthService(serviceGenerator: ServiceGenerator) : BasePart(serviceGenerator) {

    override val part: BasePart
        get() = this

    /**
     * @param listener
     */
    fun healthStatusService(listener: OnServiceStatus<HealthStatusResponse>) {
        start(serviceGenerator.createService().healthStatus(), listener)
    }

    /**
     * @param listener
     * @param questionFilter
     */
    fun questionsListService(
        listener: OnServiceStatus<ArrayList<QuestionsResponse>>,
        questionFilter: String) {
        start(serviceGenerator.createService().questions(questionFilter), listener)
    }


    /**
     * @param listener
     * @param questionId Id Of Question
     */
    fun questionsDetailService(
        listener: OnServiceStatus<ArrayList<QuestionsResponse>>,
        questionId: Int) {
        start(serviceGenerator.createService().questionsDetail(questionId), listener)
    }
}