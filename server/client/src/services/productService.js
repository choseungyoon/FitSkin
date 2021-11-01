import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:9000/api/product";

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
    return axios.put(API_URL, { product: data });
  }

  deleteProduct(data) {
    return axios.delete(API_URL, { id: data });
  }

  getProduct(data) {
    return axios.get(API_URL, { param: data });
  }
}

export default new ProductService();
