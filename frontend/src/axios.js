// axios
import axios from 'axios'

const instance  = axios.create(config)

let config ={
  baseUrl: "http://localhost:8080/", //每次请求的ip地址
  timeout: 10000,
  withCredentials: true
}


export default instance
