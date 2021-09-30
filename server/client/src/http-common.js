import axios from "axios";

export default axios.create({
  baseURL: "https://fitskin.loca.lt/api",
  headers: {
    "Content-type": "application/json",
  },
});
