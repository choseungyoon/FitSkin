import axios from 'axios'

export default axios.create({
  // aseURL: 'http://34.64.253.121:9000/api',
  baseURL: 'http://localhost:9000/api',

  headers: {
    'Content-type': 'application/json',
  },
})
