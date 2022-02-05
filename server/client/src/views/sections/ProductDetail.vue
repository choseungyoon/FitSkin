<template>
  <div id="productDetail">
    <sf-breadcrumbs
      class="breadcrumbs desktop-only"
      :breadcrumbs="breadcrumbs"
    />
    <div class="product">
      <sf-gallery
        :images="product.images"
        class="product__gallery"
    />
      <div class="product__info">
        <div class="product__header">
          <sf-heading
            :title="product.name"
            :level="1"
            class="sf-heading--no-underline sf-heading--left"
          />
          <sf-icon
            icon="drag"
            size="42px"
            color="#E0E0E1"
            class="product__drag-icon smartphone-only"
          />
        </div>
        <div class="product__price-and-rating">
          <sf-price :regular="product.price | comma" />
          <div>
            <div class="product__rating">
              <sf-rating
                :score="product.rating.rate"
                :max="product.rating.max"
              />
              <a
                v-if="!!product.reviews"
                href="#"
                class="product__count"
              >
                ({{ product.reviews.length }})
              </a>
            </div>
            <sf-button
              class="sf-button--text"
              data-testid="read-all-reviews"
              @click="changeTab(2)"
            >
              Read all reviews
            </sf-button>
          </div>
        </div>
        <div>
          <p class="product__description desktop-only">
            {{ product.description }}
          </p>
        </div>
        <sf-tabs
          id="tabs"
          :open-tab="openTab"
          class="product__tabs"
          @click:tab="changeTab"
        >
          <sf-tab
            v-for="tab in tabs"
            :key="tab.title"
            :title="tab.title"
          >
            {{ tab.content }}
            <div v-if="tab.title === 'Description'">
              <sf-property
                v-for="(detailed, i) in product.details"
                :key="i"
                :name="detailed.name"
                :value="detailed.value"
                class="product__property"
              >
                <template
                    v-if="detailed.name === 'Category'"
                    #value
                >
                  <sf-button class="sf-button--text product__property__button">
                    {{ detailed.value }}
                </sf-button>
                </template>
              </sf-property>
            </div>
            <div v-else-if="tab.title === 'Read reviews'">
              <sf-review
                v-for="(review, i) in product.reviews"
                :key="i"
                :author="review.author"
                :date="review.date"
                :message="review.message"
                :max-rating="review.rating.max"
                :rating="review.rating.rate"
                :char-limit="231"
                read-more-text="Read more"
                hide-full-text="Read less"
                class="product__review"
              />
            </div>
            <div
              v-else-if="tab.title === 'Additional Information'"
              class="product__additional-info"
            >
              <p class="product__additional-info__title">복용 시 주의사항</p>
            </div>
          </sf-tab>
        </sf-tabs>
      </div>
    </div>
    <transition name="slide">
      <sf-notification
        class="notification smartphone-only"
        :visible="isOpenNotification"
        :message="`${qty} x ${product.name} (size: ${selectedSize}, color: ${selectedColor}) has been added to cart`"
        @click:close="isOpenNotification = false"
      >
        <template #icon>
          <span></span>
        </template>
      </sf-notification>
    </transition>
  </div>
</template>
<script>
  import ProductService from '@/services/ProductService'
  import {
    SfGallery,
    SfHeading,
    SfPrice,
    SfRating,
    SfIcon,
    SfTabs,
    SfProperty,
    SfButton,
    SfReview,
    SfBreadcrumbs,
    SfNotification,
  } from '@storefront-ui/vue'
  export default {
    name: 'Product',
    props: {
      id: {
        type: String,
        default: '',
      },
    },
    components: {
      SfGallery,
      SfHeading,
      SfPrice,
      SfRating,
      SfIcon,
      SfTabs,
      SfProperty,
      SfButton,
      SfReview,
      SfBreadcrumbs,
      SfNotification,
    },
    data () {
      return {
        current: 1,
        selectedColor: 'beige',
        selectedSize: undefined,
        qty: 1,
        product: {
          name: '',
          description: '',
          images: [],
          price: '',
          rating: {
            rate: 4,
            max: 5,
          },
          details: [],
          careInstructions: 'Do not wash!',
          brand:
            '.',
          reviews: [
          ],
        },
        tabs: [
          {
            title: 'Description',
            content: '',
          },
          {
            title: 'Additional Information',
            content: '',
          },
        ],
        selected: false,
        breadcrumbs: [],
        isOpenNotification: false,
        openTab: 1,
      }
    },
    filters: {
      comma (val) {
        return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ',')
      },
    },
    methods: {
      addToCart () {
        this.isOpenNotification = true
      },
      selectColor (colorIndex) {
        this.product.colors.map((el, i) => {
          if (colorIndex === i) {
            el.selected = true
            this.selectedColor = el.name
          } else {
            el.selected = false
          }
        })
      },
      changeTab (tabNumber) {
        document
          .getElementById('tabs')
          .scrollIntoView({ behavior: 'smooth', block: 'end' })
        this.openTab = tabNumber
      },
      getProdcutDetail (id) {
        ProductService.getProduct(id).then((response) => {
          this.product.name = response.data.data.name
          this.product.description = response.data.data.etc
          this.product.price = response.data.data.price
          this.product.images.push({
            desktop: { url: response.data.data.image },
            mobile: { url: response.data.data.image },
            big: { url: response.data.data.image },
            alt: response.data.data.name,
          })
          this.product.details.push({
            name: 'Product code',
            value: response.data.data.id,
          })
          this.product.details.push({
            name: '주원료 생산지',
            value: response.data.data.origin,
          })
          this.product.details.push({
            name: '용량',
            value: response.data.data.perContent + response.data.data.unit,
          })
          this.product.details.push({
            name: '제형',
            value: response.data.data.formulation,
          })
        })
      },
    },
    created () {
      this.getProdcutDetail(this.$route.params.id)
    },
  }
</script>
<style lang="scss" scoped>
@import "~@storefront-ui/vue/styles";
#product {
  box-sizing: border-box;
  @include for-desktop {
    max-width: 1272px;
    padding: 0 var(--spacer-sm);
    margin: 0 auto;
  }
}
.product {
  @include for-desktop {
    display: flex;
  }
  &__info {
    margin: var(--spacer-xs) auto;
    @include for-desktop {
      max-width: 32.625rem;
      margin: 0 0 0 7.5rem;
    }
  }
  &__header {
    --heading-title-color: var(--c-link);
    --heading-title-font-weight: var(--font-weight--bold);
    --heading-title-font-size: var(--h3-font-size);
    --heading-padding: 0;
    margin: 0 var(--spacer-sm);
    display: flex;
    justify-content: space-between;
    @include for-desktop {
      --heading-title-font-weight: var(--font-weight--semibold);
      margin: 0 auto;
    }
  }
  &__drag-icon {
    animation: moveicon 1s ease-in-out infinite;
  }
  &__price-and-rating {
    margin: 0 var(--spacer-sm) var(--spacer-base);
    align-items: center;
    @include for-desktop {
      display: flex;
      justify-content: space-between;
      margin: var(--spacer-sm) 0 var(--spacer-lg) 0;
    }
  }
  &__rating {
    display: flex;
    align-items: center;
    justify-content: flex-end;
    margin: var(--spacer-xs) 0 var(--spacer-xs);
  }
  &__count {
    @include font(
      --count-font,
      var(--font-weight--normal),
      var(--font-size--sm),
      1.4,
      var(--font-family--secondary)
    );
    color: var(--c-text);
    text-decoration: none;
    margin: 0 0 0 var(--spacer-xs);
  }
  &__description {
    color: var(--c-link);
    @include font(
      --product-description-font,
      var(--font-weight--light),
      var(--font-size--base),
      1.6,
      var(--font-family--primary)
    );
  }
  &__select-size {
    margin: 0 var(--spacer-sm);
    @include for-desktop {
      margin: 0;
    }
  }
  &__colors {
    @include font(
      --product-color-font,
      var(--font-weight--normal),
      var(--font-size--lg),
      1.6,
      var(--font-family--secondary)
    );
    display: flex;
    align-items: center;
    margin-top: var(--spacer-xl);
  }
  &__color-label {
    margin: 0 var(--spacer-lg) 0 0;
  }
  &__color {
    margin: 0 var(--spacer-2xs);
  }
  &__add-to-cart {
    margin: var(--spacer-base) var(--spacer-sm) 0;
    @include for-desktop {
      margin-top: var(--spacer-2xl);
    }
  }
  &__guide,
  &__compare,
  &__save {
    display: block;
    margin: var(--spacer-xl) 0 var(--spacer-base) auto;
  }
  &__compare {
    margin-top: 0;
  }
  &__tabs {
    margin: var(--spacer-lg) auto var(--spacer-2xl);
    --tabs-title-font-size: var(--font-size--lg);
    @include for-desktop {
      margin-top: var(--spacer-2xl);
    }
  }
  &__property {
    margin: var(--spacer-base) 0;
    &__button {
      --button-font-size: var(--font-size--base);
    }
  }
  &__review {
    padding-bottom: 24px;
    border-bottom: var(--c-light) solid 1px;
    margin-bottom: var(--spacer-base);
  }
  &__additional-info {
    color: var(--c-link);
    @include font(
      --additional-info-font,
      var(--font-weight--light),
      var(--font-size--sm),
      1.6,
      var(--font-family--primary)
    );
    &__title {
      font-weight: var(--font-weight--normal);
      font-size: var(--font-size--base);
      margin: 0 0 var(--spacer-sm);
      &:not(:first-child) {
        margin-top: 3.5rem;
      }
    }
    &__paragraph {
      margin: 0;
    }
  }
  &__gallery {
    flex: 1;
  }
}
.breadcrumbs {
  margin: var(--spacer-base) auto var(--spacer-lg);
}
.notification {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  --notification-border-radius: 0;
  --notification-max-width: 100%;
  --notification-background: var(--c-link);
  --notification-font-size: var(--font-size--sm);
  --notification-font-family: var(--font-family--primary);
  --notification-font-weight: var(--font-weight--normal);
  --notification-padding: var(--spacer-base) var(--spacer-lg);
}

.slide-enter-active,
.slide-leave-active {
  transition: all 0.3s;
}

.slide-enter {
  transform: translateY(40px);
}

.slide-leave-to {
  transform: translateY(-80px);
}
@keyframes moveicon {
  0% {
    transform: translate3d(0, 0, 0);
  }
  50% {
    transform: translate3d(0, 30%, 0);
  }
  100% {
    transform: translate3d(0, 0, 0);
  }
}
</style>
