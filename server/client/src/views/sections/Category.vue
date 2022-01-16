<template>
  <base-section
    id="category"
    space="2"
    class="px-3"
  >
    <div class="navbar section">
      <div class="navbar__aside desktop-only">
        <sf-heading
          :level="1"
          title="Categories"
          class="navbar__title"
        />
      </div>
      <div class="navbar__main">
 <!--       <sf-button
          class="sf-button--text navbar__filters-button"
          aria-label="Filters"
          @click="isFilterSidebarOpen = true"
        >
          <sf-icon
            size="24px"
            color="#43464E"
            icon="filter2"
            class="navbar__filters-icon"
          />
          Filters
        </sf-button> -->
        <div class="navbar__sort desktop-only">
          <span class="navbar__label">Sort by:</span>
          <sf-component-select
            v-model="sortBy"
            class="navbar__select"
          >
            <sf-component-select-option
              v-for="option in sortByOptions"
              :key="option.value"
              :value="option.value"
              class="sort-by__option"
            >
              {{ option.label }}
            </sf-component-select-option>
          </sf-component-select>
        </div>
        <div class="navbar__counter">
          <span class="navbar__label desktop-only">Products found: </span>
          <span class="desktop-only">280</span>
          <span class="navbar__label smartphone-only">280 Items</span>
        </div>
        <div class="navbar__view">
          <span class="navbar__view-label desktop-only">View</span>
          <sf-icon
            class="navbar__view-icon"
            :color="'#43464E'"
            icon="tiles"
            size="12px"
            role="button"
            aria-label="Change to grid view"
            :aria-pressed="isGridView"
            @click="isGridView = true"
          />
          <sf-icon
            class="navbar__view-icon"
            :color="'#43464E'"
            icon="list"
            size="12px"
            role="button"
            aria-label="Change to list view"
            :aria-pressed="!isGridView"
            @click="isGridView = false"
          />
        </div>
      </div>
    </div>
    <div class="main section">
      <div class="sidebar desktop-only">
        <sf-accordion
          :open="sidebarAccordion[0].header"
          :show-chevron="true"
        >
          <sf-accordionItem
            v-for="(accordion, i) in sidebarAccordion"
            :key="i"
            :header="accordion.header"
          >
            <template>
              <sf-list class="list">
                <sf-listItem
                  v-for="(item, j) in accordion.items"
                  :key="j"
                  class="list__item"
                >
                  <sf-menu-item
                    :label="item.label"
                    :count="item.count"
                  />
                </sf-listItem>
              </sf-list>
            </template>
          </sf-accordionItem>
        </sf-accordion>
      </div>
      <div class="products">
        <transition-group
          v-if="isGridView"
          appear
          name="products__slide"
          tag="div"
          class="products__grid"
        >
          <sf-product-card
            v-for="(product, i) in paginatedData"
            :key="product.id"
            :style="{ '--index': i }"
            :title="product.title"
            :image="product.image"
            image-height="auto"
            image-width="100%"
            :regular-price="product.price.regular"
            :special-price="product.price.special"
            :max-rating="product.rating.max"
            :score-rating="product.rating.score"
            :is-in-wishlist="product.isInWishlist"
            :show-add-to-cart-button="true"
            class="products__product-card"
            @click:wishlist="toggleWishlist(i)"
          />
        </transition-group>
        <transition-group
          v-else
          appear
          name="products__slide"
          tag="div"
          class="products__list"
        >
          <sf-product-card-horizontal
            v-for="(product, i) in paginatedData"
            :key="product.id"
            :style="{ '--index': i }"
            :title="product.title"
            :description="product.description"
            :image="product.image"
            :regular-price="product.price.regular"
            :special-price="product.price.special"
            :max-rating="product.rating.max"
            :reviews-count="product.reviewsCount"
            :score-rating="product.rating.score"
            :is-in-wishlist="product.isInWishlist"
            class="products__product-card-horizontal"
            @click:wishlist="toggleWishlist(i)"
          >
            <template #configuration>
              <sf-property
                class="desktop-only"
                name="Size"
                value="XS"
                style="margin: 0 0 1rem 0"
              />
              <sf-property
                class="desktop-only"
                name="Color"
                value="white"
              />
            </template>
            <template #actions>
              <sf-button
                class="sf-button--text desktop-only"
                style="margin: 0 0 1rem auto; display: block"
                @click="$emit('click:add-to-wishlist')"
              >
                Save for later
              </sf-button>
              <sf-button
                class="sf-button--text desktop-only"
                style="margin: 0 0 0 auto; display: block"
                @click="$emit('click:add-to-compare')"
              >
                Add to compare
              </sf-button>
            </template>
          </sf-product-card-horizontal>
        </transition-group>
        <div>
          <br>
        </div>
        <div
          class="btn-cover"
          align="center"
        >
          <button
            :aria-disabled="false"
            type="button"
            @click="prevPage"
            aria-label="Arrow label"
          >
          <sf-icon
            class="sf-arrow__icon"
            icon="arrow_left"
            size="14px"
            viewBox="0 0 24 12"
          />
        </button>
          <span class="page-count"> {{ currentPage + 1 }} / {{ pageCount }} 페이지 </span>
        <button
          :aria-disabled="false"
          type="button"
           @click="nextPage"
          aria-label="Arrow label"
        >
          <sf-icon
            class="sf-arrow__icon"
            icon="arrow_right"
            size="14px"
            viewBox="0 0 24 12"
          />
        </button>
      </div>
      </div>
    </div>
    <sf-sidebar
      :visible="isFilterSidebarOpen"
      title="Filters"
      class="sidebar-filters"
      @close="isFilterSidebarOpen = false"
    >
      <div class="filters desktop-only">
        <sf-heading
          :level="4"
          title="Collection"
          class="filters__title sf-heading--left"
        />
        <sf-filter
          v-for="filter in filters.collection"
          :key="filter.value"
          :label="filter.label"
          :count="filter.count"
          :selected="filter.selected"
          class="filters__item"
          @change="filter.selected = !filter.selected"
        />
        <sf-heading
          :level="4"
          title="Color"
          class="filters__title sf-heading--left"
        />
        <div class="filters__colors">
          <sf-color
            v-for="filter in filters.color"
            :key="filter.value"
            :color="filter.color"
            :selected="filter.selected"
            class="filters__color"
            @click="filter.selected = !filter.selected"
          />
        </div>
        <sf-heading
          :level="4"
          title="Size"
          class="filters__title sf-heading--left"
        />
        <sf-filter
          v-for="filter in filters.size"
          :key="filter.value"
          :label="filter.label"
          :count="filter.count"
          :selected="filter.selected"
          class="filters__item"
          @change="filter.selected = !filter.selected"
        />
        <sf-heading
          :level="4"
          title="Price"
          class="filters__title sf-heading--left"
        />
        <sf-filter
          v-for="filter in filters.price"
          :key="filter.value"
          :label="filter.label"
          :count="filter.count"
          :selected="filter.selected"
          class="filters__item"
          @change="filter.selected = !filter.selected"
        />
        <sf-heading
          :level="4"
          title="Material"
          class="filters__title sf-heading--left"
        />
        <sf-filter
          v-for="filter in filters.material"
          :key="filter.value"
          :value="filter.value"
          :label="filter.label"
          :selected="filter.selected"
          class="filters__item"
          @change="filter.selected = !filter.selected"
        />
      </div>
      <sf-accordion class="filters smartphone-only">
        <sf-accordion-item
          header="Sort by"
          class="filters__accordion-item"
        >
          <template #additional-info>
            <span class="filters__chosen">
              {{ sortBy }}
            </span>
          </template>
          <sf-radio
            v-for="sort in sortByOptions"
            :key="sort.value"
            v-model="sortBy"
            :value="sort.value"
            :label="sort.label"
            class="filters__item"
          />
        </sf-accordion-item>
        <sf-accordion-item
          header="Category"
          class="filters__accordion-item"
        >
          <template #additional-info>
            <span class="filters__chosen">
              {{ category }}
            </span>
          </template>
          <sf-radio
            v-for="cat in sidebarAccordion"
            :key="cat.header"
            v-model="category"
            :value="cat.header"
            :label="cat.header"
            class="filters__item"
          />
        </sf-accordion-item>
        <sf-accordion-item
          header="Collection"
          class="filters__accordion-item"
        >
          <sf-filter
            v-for="filter in filters.collection"
            :key="filter.value"
            :label="filter.label"
            :count="filter.count"
            :selected="filter.selected"
            class="filters__item"
            @change="filter.selected = !filter.selected"
          />
        </sf-accordion-item>
        <sf-accordion-item
          header="Color"
          class="filters__accordion-item"
        >
          <sf-filter
            v-for="filter in filters.color"
            :key="filter.value"
            :label="filter.label"
            :color="filter.color"
            :selected="filter.selected"
            class="filters__item"
            @change="filter.selected = !filter.selected"
          />
        </sf-accordion-item>
        <sf-accordion-item
          header="Size"
          class="filters__accordion-item"
        >
          <sf-filter
            v-for="filter in filters.size"
            :key="filter.value"
            :label="filter.label"
            :count="filter.count"
            :selected="filter.selected"
            class="filters__item"
            @change="filter.selected = !filter.selected"
          />
        </sf-accordion-item>
        <sf-accordion-item
          header="Price"
          class="filters__accordion-item"
        >
          <sf-filter
            v-for="filter in filters.price"
            :key="filter.value"
            :label="filter.label"
            :count="filter.count"
            :selected="filter.selected"
            class="filters__item"
            @change="filter.selected = !filter.selected"
          />
        </sf-accordion-item>
        <sf-accordion-item
          header="Material"
          class="filters__accordion-item"
        >
          <sf-filter
            v-for="filter in filters.material"
            :key="filter.value"
            :value="filter.value"
            :label="filter.label"
            :selected="filter.selected"
            class="filters__item"
            @change="filter.selected = !filter.selected"
          />
        </sf-accordion-item>
      </sf-accordion>
      <template #content-bottom>
        <div class="filters__buttons">
          <sf-button
            class="sf-button--full-width"
            @click="isFilterSidebarOpen = false"
            >Done</sf-button>
          <sf-button
            class="sf-button--full-width filters__button-clear"
            @click="clearAllFilters"
            >Clear all</sf-button>
        </div>
      </template>
    </sf-sidebar>
  </base-section>

</template>
<script>
  import ProductService from '@/services/ProductService'
  import {
    SfHeading,
    SfSidebar,
    SfButton,
    SfList,
    SfIcon,
    SfMenuItem,
    SfFilter,
    SfProductCard,
    SfProductCardHorizontal,
    SfAccordion,
    SfComponentSelect,
    SfColor,
    SfProperty,
    SfRadio,
  } from '@storefront-ui/vue'
  export default {
    name: 'Category',
    components: {
      SfHeading,
      SfSidebar,
      SfButton,
      SfList,
      SfIcon,
      SfMenuItem,
      SfFilter,
      SfProductCard,
      SfProductCardHorizontal,
      SfAccordion,
      SfComponentSelect,
      SfColor,
      SfProperty,
      SfRadio,
    },
    data () {
      return {
        currentPage: 0,
        sortBy: 'Latest',
        isFilterSidebarOpen: false,
        isGridView: true,
        category: 'Clothing',
        sortByOptions: [
          {
            value: 'Latest',
            label: 'Latest',
          },
          {
            value: 'Price-up',
            label: 'Price from low to high',
          },
          {
            value: 'Price-down',
            label: 'Price from high to low',
          },
        ],
        sidebarAccordion: [
          {
            header: 'Skin Type',
            items: [
              { label: 'All', count: '280' },
              { label: '지성', count: '23' },
              { label: '건성', count: '54' },
              { label: '복합성', count: '34' },
              { label: '중성', count: '56' },
            ],
          },
          {
            header: 'Main Index',
            items: [
              { label: '수분', count: '280' },
              { label: '민강성', count: '23' },
              { label: '색소침착', count: '54' },
              { label: '트러블', count: '34' },
              { label: '민감성', count: '56' },
              { label: '피지분비', count: '7' },
            ],
          },
        ],
        products: [],
        filters: {
          collection: [
            {
              label: 'Summer fly',
              value: 'summer-fly',
              count: '10',
              selected: false,
            },
            {
              label: 'Best 2018',
              value: 'best-2018',
              count: '23',
              selected: false,
            },
            {
              label: 'Your choice',
              value: 'your-choice',
              count: '54',
              selected: false,
            },
          ],
          color: [
            { label: 'Red', value: 'red', color: '#990611', selected: false },
            { label: 'Black', value: 'black', color: '#000000', selected: false },
            {
              label: 'Yellow',
              value: 'yellow',
              color: '#DCA742',
              selected: false,
            },
            { label: 'Blue', value: 'blue', color: '#004F97', selected: false },
            { label: 'Navy', value: 'navy', color: '#656466', selected: false },
          ],
          size: [
            { label: 'Size 2 (XXS)', value: 'xxs', count: '10', selected: false },
            { label: 'Size 4-6 (XS)', value: 'xs', count: '23', selected: false },
            { label: 'Size 8-10 (S)', value: 's', count: '54', selected: false },
            {
              label: 'Size 12-14 (M)',
              value: 'm',
              count: '109',
              selected: false,
            },
            { label: 'Size 16-18 (L)', value: 'l', count: '23', selected: false },
            {
              label: 'Size 20-22(XL)',
              value: 'xl',
              count: '12',
              selected: false,
            },
            {
              label: 'Size 24-26 (XXL)',
              value: 'xxl',
              count: '2',
              selected: false,
            },
          ],
          price: [
            {
              label: 'Under $200',
              value: 'under-200',
              count: '23',
              selected: false,
            },
            {
              label: 'Under $300',
              value: 'under-300',
              count: '54',
              selected: false,
            },
          ],
          material: [
            { label: 'Cotton', value: 'coton', count: '33', selected: false },
            { label: 'Silk', value: 'silk', count: '73', selected: false },
          ],
        },
      }
    },
    methods: {
      clearAllFilters () {
        const filters = Object.keys(this.filters)
        filters.forEach((name) => {
          const prop = this.filters[name]
          prop.forEach((value) => {
            value.selected = false
          })
        })
      },
      toggleWishlist (index) {
        this.products[index].isInWishlist = !this.products[index].isInWishlist
      },
      getProduct () {
        var ref = this
        ProductService.getProductAll().then((response) => {
          ref.products = []
          var idx = 1
          response.data.forEach(function (element) {
            ref.products.push({
              title: element.name,
              id: idx,
              description:
                'Find stunning women cocktail and party dresses. Stand out in lace and metallic cocktail dresses and party dresses from all your favorite brands.',
              image: element.image,
              price: { regular: element.price },
              rating: { max: 5, score: 4 },
              reviewsCount: 8,
              isInWishlist: false,
            })
            idx = idx + 1
          })
        })
      },
      nextPage () {
        if (this.currentPage === this.pageTotal) {
          return
        }
        this.currentPage += 1
      },
      prevPage () {
        if (this.currentPage === 0) {
          return
        }
        this.currentPage -= 1
      },
    },
    computed: {
      pageCount () {
        var pageTotal = Math.floor(this.products.length / 8)
        if (this.products.length % 8 > 0) pageTotal += 1
        return pageTotal
      },
      paginatedData () {
        var start = (this.currentPage) * 8
        var end = start + 8
        return this.products.slice(start, end)
      },
    },
    created: function () {
      this.getProduct()
    },
  }
  </script>
  <style lang="scss" scoped>
  @import "~@storefront-ui/vue/styles";
  #category {
    box-sizing: border-box;
    @include for-desktop {
      max-width: 100%;
      margin: 0 auto;
    }
  }
  .main {
    &.section {
      padding: var(--spacer-xs);
      @include for-desktop {
        padding: 0;
      }
    }
  }
  .navbar {
    position: relative;
    display: flex;
    border: 1px solid var(--c-light);
    border-width: 0 0 1px 0;
    @include for-desktop {
      border-width: 1px 0 1px 0;
    }
    &.section {
      padding: var(--spacer-sm);
      @include for-desktop {
        padding: 0;
      }
    }
    &__aside,
    &__main {
      display: flex;
      align-items: center;
      padding: var(--spacer-sm) 0;
    }
    &__aside {
      flex: 0 0 15%;
      padding: var(--spacer-sm) var(--spacer-sm);
      border: 1px solid var(--c-light);
      border-width: 0 1px 0 0;
    }
    &__main {
      flex: 1;
      display: flex;
      padding: 0;
      @include for-desktop {
        padding: var(--spacer-xs) var(--spacer-xl);
      }
    }
    &__title {
      --heading-title-font-weight: var(--font-weight--semibold);
      --heading-title-font-size: var(--h3-font-size);
    }
    &__filters-icon {
      margin: 0 0 0 var(--spacer-2xs);
      order: 1;
      @include for-desktop {
        margin: 0 var(--spacer-xs) 0 0;
        order: 0;
      }
    }
    &__filters-button {
      display: flex;
      align-items: center;
      --button-font-size: var(--font-size--base);
      --button-text-decoration: none;
      --button-color: var(--c-link);
      --button-font-weight: var(--font-weight--normal);
      @include for-mobile {
        --button-font-weight: var(--font-weight--medium);
        margin-right: var(--spacer-sm);
        order: 1;
      }
      svg {
        fill: var(--c-text-muted);
        transition: fill 150ms ease;
      }
      &:hover {
        svg {
          fill: var(--c-primary);
        }
      }
    }
    &__label {
      font-family: var(--font-family--secondary);
      font-weight: var(--font-weight--normal);
      color: var(--c-text-muted);
      @include for-desktop {
        margin: 0 var(--spacer-2xs) 0 0;
      }
    }
    &__select {
      --component-select-width: 220px;
      --component-select-padding: 0;
      --component-select-selected-padding: 0 var(--spacer-lg) 0 var(--spacer-2xs);
      --component-select-margin: 0;
      --component-select-error-message-height: 0;
    }
    &__sort {
      display: flex;
      align-items: center;
      margin: 0 auto 0 var(--spacer-2xl);
    }
    &__counter {
      font-family: var(--font-family--secondary);
      margin: auto;
      @include for-desktop {
        margin: auto 0 auto auto;
      }
    }
    &__view {
      display: flex;
      order: -1;
      align-items: center;
      margin: 0;
      @include for-desktop {
        margin: 0 0 0 var(--spacer-2xl);
        order: 0;
      }
      &-icon {
        cursor: pointer;
        margin: 0 var(--spacer-base) 0 var(--spacer-sm);
        @include for-desktop {
          margin: 0 var(--spacer-base) 0 0;
        }
        &:last-child {
          margin: 0;
        }
      }
      &-label {
        margin: 0 var(--spacer-sm) 0 0;
        font: var(--font-weight--normal) var(--font-size--base) / 1.6
          var(--font-family--secondary);
        text-decoration: none;
        color: var(--c-link);
      }
    }
  }
  .sort-by {
    --component-select-dropdown-z-index: 1;
    flex: unset;
    width: 11.875rem;
  }
  .main {
    display: flex;
  }
  .sidebar {
    flex: 0 0 15%;
    padding: var(--spacer-sm);
    border: 1px solid var(--c-light);
    border-width: 0 1px 0 0;
  }
  .sidebar-filters {
    --sidebar-title-display: none;
    --sidebar-top-padding: 10%;
    @include for-desktop {
      --sidebar-content-padding: 0 var(--spacer-xl);
      --sidebar-bottom-padding: 0 var(--spacer-xl);
    }
  }
  .list {
    --menu-item-font-size: var(--font-size--sm);
    &__item {
      &:not(:last-of-type) {
        --list-item-margin: 0 0 var(--spacer-sm) 0;
      }
    }
  }
  .products {
    box-sizing: border-box;
    flex: 1;
    margin: 0;
    &__grid,
    &__list {
      display: flex;
      flex-wrap: wrap;
    }
    &__grid {
      justify-content: center;
      @include for-desktop {
        justify-content: space-between;
      }
    }
    &__product-card {
      --product-card-max-width: 11rem;
      --product-card-title-margin: var(--spacer-2xs) 0 0 0;
      --price-regular-font-line-height: 1;
      margin-bottom: var(--spacer-sm);
      ::v-deep .sf-product-card__price {
        margin: var(--spacer-2xs) 0 var(--spacer-xs);
      }
      flex: 1 1 50%;
      @include for-desktop {
        margin-bottom: 0;
        --product-card-max-width: 50%;
        --product-card-title-margin: var(--spacer-base) 0 0 0;
      }
    }
    &__product-card-horizontal {
      margin-bottom: var(--spacer-sm);
      flex: 0 0 100%;
      ::v-deep .sf-product-card-horizontal__wishlist-icon {
        .sf-icon {
          width: 1.5rem;
          height: 1.5rem;
        }
      }
    }
    &__slide-enter {
      opacity: 0;
      transform: scale(0.5);
    }
    &__slide-enter-active {
      transition: all 0.2s ease;
      transition-delay: calc(0.1s * var(--index));
    }
    &__pagination {
      display: flex;
      justify-content: center;
      margin: var(--spacer-base) 0;
    }
    @include for-desktop {
      margin: var(--spacer-sm) 0 0 var(--spacer-sm);
      &__pagination {
        justify-content: flex-start;
        margin: var(--spacer-xl) 0 0 0;
      }
      &__product-card-horizontal {
        margin: var(--spacer-lg) 0;
      }
      &__product-card {
        flex: 1 1 25%;
      }
      &__list {
        margin: 0 0 0 var(--spacer-sm);
      }
    }
    &__show-on-page {
      display: flex;
      justify-content: flex-end;
      align-items: baseline;
      &__label {
        font-family: var(--font-family--secondary);
        font-size: var(--font-size--sm);
      }
    }
  }
  .filters {
    &__title {
      --heading-title-font-size: var(--font-size--xl);
      margin: var(--spacer-xl) 0 var(--spacer-base) 0;
      &:first-child {
        margin: calc(var(--spacer-xl) + var(--spacer-base)) 0 var(--spacer-xs) 0;
      }
    }
    &__colors {
      display: flex;
    }
    &__color {
      margin: var(--spacer-xs) var(--spacer-xs) var(--spacer-xs) 0;
    }
    &__chosen {
      color: var(--c-text-muted);
      font-weight: var(--font-weight--normal);
      font-family: var(--font-family--secondary);
      position: absolute;
      right: var(--spacer-xl);
    }
    &__item {
      --radio-container-padding: 0 var(--spacer-sm) 0 var(--spacer-xl);
      --radio-background: transparent;
      --filter-label-color: var(--c-secondary-variant);
      --filter-count-color: var(--c-secondary-variant);
      --checkbox-padding: 0 var(--spacer-sm) 0 var(--spacer-xl);
      padding: var(--spacer-sm) 0;
      border-bottom: 1px solid var(--c-light);
      &:last-child {
        border-bottom: 0;
      }
      @include for-desktop {
        --checkbox-padding: 0;
        margin: var(--spacer-sm) 0;
        border: 0;
        padding: 0;
      }
    }
    &__accordion-item {
      --accordion-item-content-padding: 0;
      position: relative;
      left: 50%;
      right: 50%;
      margin-left: -50vw;
      margin-right: -50vw;
      width: 100vw;
    }
    &__buttons {
      margin: var(--spacer-sm) 0;
    }
    &__button-clear {
      --button-background: var(--c-light);
      --button-color: var(--c-dark-variant);
      margin: var(--spacer-xs) 0 0 0;
    }
  }
  </style>
