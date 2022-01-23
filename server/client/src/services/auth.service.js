import axios from 'axios'
import authHeader from './auth-header'

// const API_URL = 'http://34.64.253.121:9000/api/auth/'
const API_URL = 'http://localhost:9000/api/auth/'

class AuthService {
  login (user) {
    return axios
      .post(API_URL + 'signin', {
        email: user.email,
        password: user.password,
      })
      .then((response) => {
        if (response.data.accessToken) {
          localStorage.setItem('user', JSON.stringify(response.data))
        }

        return response.data
      })
  }

  logout () {
    localStorage.removeItem('user')
  }

  register (user) {
    return axios.post(API_URL + 'signup', {
      username: user.name,
      email: user.email,
      password: user.password,
    })
  }

  updateAccount (user) {
    return axios.put(API_URL + 'update/account', {
      id: user.id,
      username: user.name,
      email: user.email,
      password: user.password,
    },
    { headers: authHeader() })
  }
}

export default new AuthService()
