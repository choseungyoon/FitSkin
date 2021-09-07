<template>
    <div class="product_search">

         <div class="item">
            <b-card
                title="Self 피부타입 진단"
                img-src="https://i1.wp.com/diycrafts9.com/wp-content/uploads/2020/09/What-is-your-skin-type-1.jpg?fit=844%2C621&ssl=1"
                img-alt="Image"
                img-top
                img-height="200"
                img-width="200"
                tag="article"
                style="max-width: 30rem;"
                class="mb-2"
            >
                <b-card-text>
                    몇가지 진단을 통해 나의 피부 타입을 확인할 수 있습니다. <br>
                    약 5분의 시간이 소요됩니다. 
                </b-card-text>

                <b-button to="/survey" variant="primary">피부진단 시작하기</b-button>
            </b-card>
        </div>
        <div class="item">
            <b-card
                title="유전자 키트"
                img-src="https://cdn.bosa.co.kr/news/photo/201909/2111765_152494_1815.jpg"
                img-alt="Image"
                img-top
                img-height="200"
                img-width="200"
                tag="article"
                style="max-width: 30rem;"
                class="mb-2"
            >
                <b-card-text>
                    유전자 키트를 통해 보다 정확한 진단을 받을 수 있습니다.<br>
                    집으로 유전자 검사 키트가 발송됩니다. 
                </b-card-text>

                <b-button href="#" variant="primary">유전자키트 받기</b-button>
            </b-card>
         </div>
    </div>
</template>

<style scoped>
.product_search {
    display: flex;
    flex-flow: row wrap;
    justify-content: space-evenly;
    margin-top: 5%;
}
.item {
    flex-basis: auto;
}
</style>