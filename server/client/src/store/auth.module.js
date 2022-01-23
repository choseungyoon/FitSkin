import AuthService from '@/services/auth.service'

const user = JSON.parse(localStorage.getItem('user'))
const initialState = user
  ? { status: { loggedIn: true }, user }
  : { status: { loggedIn: false }, user: null }

export const auth = {
  namespaced: true,
  state: initialState,
  actions: {
    login ({ commit }, user) {
      return AuthService.login(user).then(
        (user) => {
          commit('loginSuccess', user)
          return Promise.resolve(user)
        },
        (error) => {
          commit('loginFailure')
          return Promise.reject(error)
        },
      )
    },
    logout ({ commit }) {
      AuthService.logout()
      commit('logout')
    },
    register ({ commit }, user) {
      return AuthService.register(user).then(
        (response) => {
          commit('registerSuccess')
          return Promise.resolve(response.data)
        },
        (error) => {
          commit('registerFailure')
          return Promise.reject(error)
        },
      )
    },
    update ({ commit }, user) {
      return AuthService.updateAccount(user).then(
        (response) => {
          commit('updateSuccess', user)
          return Promise.resolve(user)
        },
      )
    },
    loginByKakao ({ commit }, codes) {
      console.log('auth.modules')
      console.log('codes : ' + codes)
      return AuthService.loginByKakao(codes).then(
        (user) => {
          console.log('auth.modules - login success')
          console.log('user : ' + user)
          commit('loginSuccess', user)
          return Promise.resolve(user)
        },
        (error) => {
          console.log('auth.modules - login fail')
          console.log('error :' + error)
          commit('loginFailure')
          return Promise.reject(error)
        },
      )
    },
  },
  mutations: {
    loginSuccess (state, user) {
      state.status.loggedIn = true
      state.user = user
    },
    loginFailure (state) {
      state.status.loggedIn = false
      state.user = null
    },
    logout (state) {
      state.status.loggedIn = false
      state.user = null
    },
    registerSuccess (state) {
      state.status.loggedIn = false
    },
    registerFailure (state) {
      state.status.loggedIn = false
    },
    updateSuccess (state, user) {
      state.status.loggedIn = true
      state.user = user
    },
  },
}
