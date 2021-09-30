<template>
  <v-footer>
    <v-card flat tile class="teal accent-4 white--text text-center">
      <v-card-text>
        <v-btn v-for="icon in icons" :key="icon" class="mx-4 white--text" icon>
          <v-icon size="24px">
            {{ icon }}
          </v-icon>
        </v-btn>
      </v-card-text>

      <v-card-text class="white--text pt-0">
        핏스킨 <br />
        주식회사 라이크팜 |사업자번호: 285-81-02331|대표: 주민중
        <br />
        개인정보취급담당자: 김수민 인천광역시 연수구 해돋이로 107, 에프동<br />
        612호 통신판매업 : 2021-인천연수구-1720호 건강기능식품일반판매업:
        2021-0200231호
        <br />사업자정보확인링크
        (https://www.ftc.go.kr/www/bizCommView.do?key=3765&apv_perm_no=2021352019230201720&pageUnit=10&searchCnd=wrkr_no&searchKrwd=2858102331&pageIndex=1)<br />
        고객센터 고객문의: fitskin12@gmail.com
      </v-card-text>

      <v-divider></v-divider>

      <v-card-text class="white--text">
        {{ new Date().getFullYear() }} — <strong>FitSkin</strong>
      </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    icons: ["mdi-facebook", "mdi-twitter", "mdi-linkedin", "mdi-instagram"],
  }),
};
</script>
