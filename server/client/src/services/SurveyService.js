import http from '@/services/http-common'

class SurveyService {
  getForm () {
    return http.get('/survey/form')
  }

  insertResult (data, email) {
    return http.post('/survey/result', { result: data, user: email })
  }

  getResult (data) {
    return http.get(`/survey/result?id=${data}`)
  }

  getAllResult (data) {
    return http.get(`/survey/result/all?email=${data}`)
  }

  getBestIndex (data) {
    return http.get(`/analysis/index/best?id=${data}`)
  }

  getWorstIndex (data) {
    return http.get(`/analysis/index/worst?id=${data}`)
  }

  getRecommendHabits (data) {
    return http.get(`/analysis/habits?index=${data}`)
  }
}

export default new SurveyService()
