<template>
  <base-section
    id="ready-service"
  >
    <v-row
      align="center"
      justify="center"
    >
        <v-col
          cols="12"
          md="12"
          class="px-10"
        >
            <center>
                <span class="text-h2 font-weight-black">
                    열심히 오픈 준비중입니다.
                </span>
            </center>
        </v-col>
    </v-row>
    <v-row>
        <br>
    </v-row>
    <v-row
      align="center"
      justify="center"
    >
        <v-col
          cols="12"
          md="12"
          class="px-10"
        >
            <center>
                <span class="text-h5 font-weight-black">
                    유전자 검사를 통해 보다 정확한 진단과 제품을 추천받을 수 있어요
                </span>
            </center>
        </v-col>
    </v-row>
    <v-row
      align="center"
      justify="center"
    >
        <v-col
          cols="12"
          md="12"
          class="px-10"
        >
            <center>
                <span class="text-h5 font-weight-black">
                    오픈 전 FitSkin 맞춤진단 먼저 만나보세요
                </span>
            </center>
        </v-col>
    </v-row>
    <center>
        <router-link
            to="/survey"
            tag="button"
            >
            <base-btn
                class="my-10 elevation-0 mx-1"
                rounded
                color="black"
                dark
                depressed
                target="_blank"
            >
                <span
                class="font-weight-black text-none"
                v-text="`${appData.title} 피부 비타민 추천`"
                />
            </base-btn>
        </router-link>
    </center>
  </base-section>
</template>
