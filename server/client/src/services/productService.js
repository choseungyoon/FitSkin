import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://34.64.253.121:9000/api/product";
//const API_URL = "http://localhost:9000/api/product";

class ProductService {
  insertProduct(data) {
    return axios.post(API_URL, {
      name: data.name,
      ingredientCode: data.ingredientCode,
      subIngredient: data.subIngredient,
      formulation: data.formulation,
      registeredDate: data.registeredDate,
      origin: data.origin,
      perContent: data.perContent,
      price: data.price,
      totalVolume: data.totalVolume,
      dayVolume: data.dayVolume,
      image: data.image,
      etcIngredient: data.etcIngredient,
      description: data.description,
    });
  }

  updateProduct(data) {
    return axios.put(API_URL, {
      productId: data.productId,
      name: data.name,
      ingredientCode: data.ingredientCode,
      subIngredient: data.subIngredient,
      formulation: data.formulation,
      registeredDate: data.registeredDate,
      origin: data.origin,
      perContent: data.perContent,
      price: data.price,
      totalVolume: data.totalVolume,
      dayVolume: data.dayVolume,
      image: data.image,
      etcIngredient: data.etcIngredient,
      description: data.description,
    });
  }

  deleteProduct(data) {
    return axios.delete(API_URL, { id: data });
  }

  searchProduct(data) {
    return axios.get(API_URL + `/search?param=${data}`);
  }

  getProduct(data) {
    return axios.get(API_URL + `?id=${data}`);
  }

  getProductAll() {
    return axios.get(API_URL + "/all");
  }

  getProductByIndex(data) {
    return axios.get(API_URL + `/search/index?index=${data}`);
  }

  getIngredientAll() {
    return axios.get(API_URL + "/ingredient");
  }
  recommendIngredient(data) {
    return axios.get(API_URL + `/ingredient/recommend?index=${data}`);
  }
}

export default new ProductService();
