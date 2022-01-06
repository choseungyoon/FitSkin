<template>
  <base-section
    class="offblack"
  >
    <v-theme-provider>
      <v-row
        no-gutters
        class="px-12"
        align="start"
        justify="center"
      >
        <v-col
          cols="12"
          md="2"
          class="px-3"
        />
        <v-col
          cols="12"
          md="4"
          class="px-3"
        >
          <base-subheading :title="`About ${appData.title}`" />
          <base-divider
            color="white"
            align="left"
          />
          <base-body
            space="2"
            text="주식회사 라이크팜"
          />
          <base-body
            space="2"
            text="사업자번호: 285-81-02331"
          />
          <base-body
            space="2"
            text="대표: 주민중"
          />
          <base-body
            space="2"
            text="개인정보취급담당자: 김수민"
          />
          <base-body
            space="2"
            text="인천광역시 연수구 해돋이로 107, 에프동  612호"
          />
          <base-body
            space="2"
            text="통신판매업 : 2021-인천연수구-1720호 "
          />
          <base-body
            space="2"
            text="건강기능식품일반판매업: 2021-0200231호 "
          />
          <a
            href="https://www.ftc.go.kr/www/bizCommView.do?key=3765&apv_perm_no=2021352019230201720&pageUnit=10&searchCnd=wrkr_no&searchKrwd=2858102331&pageIndex=1"
          >
            <base-body
              space="2"
              text="사업자정보확인"
            />
          </a>
        </v-col>
        <v-col
          cols="12"
          md="4"
          class="px-3"
        >
          <base-subheading title="Contact Us" />
          <base-divider
            color="white"
            align="left"
          />
          <base-subtitle
            title="Phone:"
            weight="bold"
          />
          <base-body
            space="2"
            :text="appData.contact.phone.value"
          />
          <base-subtitle
            title="Email:"
            weight="bold"
          />
          <base-body
            space="2"
            :text="appData.contact.email.value"
          />
          <base-subheading title="Follow Us" />
          <base-divider
            color="white"
            align="left"
          />
          <base-btn
            v-for="media in appData.socialLinks"
            :key="media.link"
            :href="media.link"
            target="_blank"
            class="ma-1"
            min-width="40px"
            width="40px"
            depressed
            :color="media.color"
            :icon="media.icon"
          />
        </v-col>
        <v-col
          cols="12"
          md="2"
          class="px-3"
        />
      </v-row>
    </v-theme-provider>
  </base-section>
</template>

<script>
  export default {
    name: 'SectionInfo',
  }
</script>

<style scoped>
#offblack {
  background-color: black;
}
</style>
