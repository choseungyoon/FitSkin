const path = require("path");
module.exports = {
  //assetsDir: "../src/main/resources/static",
  //   assetsDir: "./"
  //   asset 파일 위치 설정
  outputDir: path.resolve(__dirname, "/Users/seungyuncho/Project/FitSkin-backend/server/src/main/resources/static"),

  transpileDependencies: [
    'vuetify'
  ]
};


