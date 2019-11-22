<template>
  <div class="det-root">
    <div class="header">
      <img class="header-bg" :src="'https://images.weserv.nl/?url='+bookDetaile.pic" />
      <div class="book-cover">
        <img
          :alt="bookDetaile.title"
          :src="'https://images.weserv.nl/?url='+bookDetaile.pic"
          class="cover-img"
          style="cursor: pointer;"
        />
      </div>
      <span>
        <div class="bg-set">
          <img
            :src="'https://images.weserv.nl/?url='+bookDetaile.pic"
            alt
            class="jsx-1717929417 inner"
            style="opacity: 0;"
          />
        </div>
      </span>
    </div>

    <div class="all-context">
      <div class="user-rec">
        <div class="rec-modal">
          <div style="margin-right: 10px;">
            <div style=" flex-flow: row-reverse;">
              <span class="user-header" style="margin-right: -5.5px;">
                <img
                  alt
                  :src="'https://images.weserv.nl/?url='+bookDetaile.pic"
                  class="user-header-set"
                />
              </span>
              <span class="user-header" style="margin-right: -5.5px;">
                <img
                  alt
                  :src="'https://images.weserv.nl/?url='+bookDetaile.pic"
                  class="user-header-set"
                />
              </span>
              <span class="user-header">
                <img
                  alt
                  :src="'https://images.weserv.nl/?url='+bookDetaile.pic"
                  class="user-header-set"
                />
              </span>
            </div>
          </div>
          <div style="flex: 1 1 0%;">
            <span class="user-name">Resonated Daydream</span>
            <span style="    margin-left: -0.2em;">
              等
              <span style="padding-right: .25em;padding-left: .25em;">17</span>人
            </span>
            <span style="margin-right: 0.5em;margin-left: -0.25em;">卖过这本书</span>
          </div>
          <svg
            viewBox="0 0 24 24"
            fill="none"
            stroke="rgb(210, 210, 210)"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            xmlns="http://www.w3.org/2000/svg"
            class="Icon"
          >
            <polyline points="9 18 15 12 9 6" />
          </svg>
        </div>
      </div>

      <div class="desc-content">
        <div class="content-bookname">
          <h1 class="bookname-set">{{bookDetaile.title}}</h1>
        </div>
        <div class="content-price">
          <span
            class="price-set"
          >￥{{bookDetaile.appearance == appearance_new ? (bookDetaile.price*0.75).toFixed(2) : bookDetaile.appearance == appearance_good ? (bookDetaile.price*0.5).toFixed(2) : (bookDetaile.price*0.4).toFixed(2)}}</span>
          <div class="price-discount">
            <span class="discount-set">
              <span style="margin-right: 3px;">二手</span>
              {{bookDetaile.appearance == appearance_new ? 7.5 : bookDetaile.appearance == appearance_good ? 5 : 4}} 折
            </span>
          </div>
        </div>
        <div class="content-more">
          <div class="condition">
            <div class="condition-set">
              <span class="font-set">品&ensp; 相</span>
            </div>
            <div class="condition-type">
              <span
                class="type-set"
              >{{bookDetaile.appearance == appearance_new ? "全新品" : bookDetaile.appearance == appearance_good ? "品相良好" : "品相中等"}}</span>
              <router-link class="type-link" to="/support/condition">
                <svg
                  viewBox="0 0 24 24"
                  fill="none"
                  stroke="rgb(170, 170, 170)"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  xmlns="http://www.w3.org/2000/svg"
                  class="Icon"
                >
                  <circle cx="12" cy="12" r="10" />
                  <line x1="12" y1="16" x2="12" y2="12" />
                  <line x1="12" y1="8" x2="12" y2="8" />
                </svg>
              </router-link>
            </div>
          </div>
          <div class="original-price">
            <div class="condition-set">
              <span class="font-set">原&ensp; 价</span>
            </div>
            <div class="condition-type">
              <span class="type-set" style="color: rgb(51, 51, 51);">￥{{bookDetaile.price}}</span>
            </div>
          </div>
          <div class="original-price">
            <div class="condition-set">
              <span class="font-set">作&ensp; 者</span>
            </div>
            <div class="condition-type">
              <span class="type-set" style="color: rgb(24, 195, 170);">{{bookDetaile.author}}</span>
            </div>
          </div>
          <div class="original-price">
            <div class="condition-set">
              <span class="font-set">出版社</span>
            </div>
            <div class="condition-type">
              <span class="type-set">{{bookDetaile.publisher}}</span>
            </div>
          </div>
          <div class="original-price">
            <div class="condition-set">
              <span class="font-set">出&ensp; 版</span>
            </div>
            <div class="condition-type">
              <span class="type-set" style="color: rgb(51, 51, 51);">{{bookDetaile.pubdate}}</span>
            </div>
          </div>
          <div class="original-price">
            <div class="condition-set">
              <span class="font-set">装&ensp; 帧</span>
            </div>
            <div class="condition-type">
              <span class="type-set">{{bookDetaile.binding}}</span>
            </div>
          </div>
        </div>
      </div>

      <div class="douban">
        <div class="douban-set">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="17"
            height="16"
            viewBox="0 0 15 14"
            color="rgb(214, 186, 140)"
          >
            <path
              fill="none"
              stroke="currentColor"
              stroke-linecap="round"
              stroke-linejoin="round"
              d="M20.1574053,24.6826336 L17.0453067,25.9566366 C16.6579438,26.1148978 16.2357087,25.8185976 16.2724658,25.4141522 L16.5646374,22.1601253 C16.5853721,21.9315257 16.5090305,21.7038054 16.3525774,21.5305973 L14.1367858,19.0634804 C13.861579,18.7566294 14.0227447,18.2774496 14.4317849,18.1860098 L17.7248413,17.4483365 C17.9566936,17.396462 18.1565012,17.2566646 18.2799673,17.0597173 L20.0226293,14.261131 C20.2394018,13.9129563 20.7615407,13.9129563 20.9783131,14.261131 L22.7209752,17.0597173 C22.8434988,17.2566646 23.0433064,17.396462 23.2751587,17.4483365 L26.5682151,18.1860098 C26.9772553,18.2774496 27.138421,18.7566294 26.8632142,19.0634804 L24.6474226,21.5305973 C24.491912,21.7038054 24.4155704,21.9315257 24.4363051,22.1601253 L24.7284767,25.4141522 C24.7642913,25.8185976 24.3420562,26.1148978 23.9546933,25.9566366 L20.8425947,24.6826336 C20.6239373,24.5929522 20.3760627,24.5929522 20.1574053,24.6826336 Z"
              transform="translate(-13 -13)"
            />
          </svg>
          <span class="douban-desc">
            豆瓣评分
            <span class="desc-score">{{bookDetaile.score }}</span>
          </span>

          <div style="display:flex">
            <div style="margin-right:3px">
              <div class="desc-star" v-if="bookDetaile.score>=1">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  color="rgb(214, 186, 140)"
                  width="13"
                  height="12"
                  viewBox="0 0 13 12"
                >
                  <path
                    fill="currentColor"
                    fill-rule="evenodd"
                    d="M6.15740527,10.6826336 L3.04530674,11.9566366 C2.65794378,12.1148978 2.23570873,11.8185976 2.27246579,11.4141522 L2.56463737,8.16012531 C2.58537213,7.93152574 2.50903052,7.7038054 2.35257736,7.53059727 L0.136785824,5.06348041 C-0.13842095,4.75662945 0.0227446608,4.27744959 0.431784867,4.18600976 L3.72484127,3.44833654 C3.95669356,3.39646203 4.15650121,3.2566646 4.27996727,3.05971728 L6.02262934,0.261131044 C6.2394018,-0.0870436812 6.76154068,-0.0870436812 6.97831314,0.261131044 L8.72097522,3.05971728 C8.84349879,3.2566646 9.04330644,3.39646203 9.27515873,3.44833654 L12.5682151,4.18600976 C12.9772553,4.27744959 13.138421,4.75662945 12.8632142,5.06348041 L10.6474226,7.53059727 C10.491912,7.7038054 10.4155704,7.93152574 10.4363051,8.16012531 L10.7284767,11.4141522 C10.7642913,11.8185976 10.3420562,12.1148978 9.95469326,11.9566366 L6.84259473,10.6826336 C6.6239373,10.5929522 6.3760627,10.5929522 6.15740527,10.6826336 Z"
                  />
                </svg>
              </div>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="13"
                height="12"
                viewBox="0 0 13 12"
                color="rgb(242, 242, 242)"
              >
                <path
                  fill="currentColor"
                  fill-rule="evenodd"
                  d="M6.15740527,10.6826336 L3.04530674,11.9566366 C2.65794378,12.1148978 2.23570873,11.8185976 2.27246579,11.4141522 L2.56463737,8.16012531 C2.58537213,7.93152574 2.50903052,7.7038054 2.35257736,7.53059727 L0.136785824,5.06348041 C-0.13842095,4.75662945 0.0227446608,4.27744959 0.431784867,4.18600976 L3.72484127,3.44833654 C3.95669356,3.39646203 4.15650121,3.2566646 4.27996727,3.05971728 L6.02262934,0.261131044 C6.2394018,-0.0870436812 6.76154068,-0.0870436812 6.97831314,0.261131044 L8.72097522,3.05971728 C8.84349879,3.2566646 9.04330644,3.39646203 9.27515873,3.44833654 L12.5682151,4.18600976 C12.9772553,4.27744959 13.138421,4.75662945 12.8632142,5.06348041 L10.6474226,7.53059727 C10.491912,7.7038054 10.4155704,7.93152574 10.4363051,8.16012531 L10.7284767,11.4141522 C10.7642913,11.8185976 10.3420562,12.1148978 9.95469326,11.9566366 L6.84259473,10.6826336 C6.6239373,10.5929522 6.3760627,10.5929522 6.15740527,10.6826336 Z"
                />
              </svg>
            </div>
          </div>

          <div style="display:flex">
            <div style="margin-right:3px">
              <div class="desc-star" v-if="bookDetaile.score>=3">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="13"
                  height="12"
                  viewBox="0 0 13 12"
                  color="rgb(214, 186, 140)"
                >
                  <path
                    fill="currentColor"
                    fill-rule="evenodd"
                    d="M6.15740527,10.6826336 L3.04530674,11.9566366 C2.65794378,12.1148978 2.23570873,11.8185976 2.27246579,11.4141522 L2.56463737,8.16012531 C2.58537213,7.93152574 2.50903052,7.7038054 2.35257736,7.53059727 L0.136785824,5.06348041 C-0.13842095,4.75662945 0.0227446608,4.27744959 0.431784867,4.18600976 L3.72484127,3.44833654 C3.95669356,3.39646203 4.15650121,3.2566646 4.27996727,3.05971728 L6.02262934,0.261131044 C6.2394018,-0.0870436812 6.76154068,-0.0870436812 6.97831314,0.261131044 L8.72097522,3.05971728 C8.84349879,3.2566646 9.04330644,3.39646203 9.27515873,3.44833654 L12.5682151,4.18600976 C12.9772553,4.27744959 13.138421,4.75662945 12.8632142,5.06348041 L10.6474226,7.53059727 C10.491912,7.7038054 10.4155704,7.93152574 10.4363051,8.16012531 L10.7284767,11.4141522 C10.7642913,11.8185976 10.3420562,12.1148978 9.95469326,11.9566366 L6.84259473,10.6826336 C6.6239373,10.5929522 6.3760627,10.5929522 6.15740527,10.6826336 Z"
                  />
                </svg>
              </div>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="13"
                height="12"
                viewBox="0 0 13 12"
                color="rgb(242, 242, 242)"
              >
                <path
                  fill="currentColor"
                  fill-rule="evenodd"
                  d="M6.15740527,10.6826336 L3.04530674,11.9566366 C2.65794378,12.1148978 2.23570873,11.8185976 2.27246579,11.4141522 L2.56463737,8.16012531 C2.58537213,7.93152574 2.50903052,7.7038054 2.35257736,7.53059727 L0.136785824,5.06348041 C-0.13842095,4.75662945 0.0227446608,4.27744959 0.431784867,4.18600976 L3.72484127,3.44833654 C3.95669356,3.39646203 4.15650121,3.2566646 4.27996727,3.05971728 L6.02262934,0.261131044 C6.2394018,-0.0870436812 6.76154068,-0.0870436812 6.97831314,0.261131044 L8.72097522,3.05971728 C8.84349879,3.2566646 9.04330644,3.39646203 9.27515873,3.44833654 L12.5682151,4.18600976 C12.9772553,4.27744959 13.138421,4.75662945 12.8632142,5.06348041 L10.6474226,7.53059727 C10.491912,7.7038054 10.4155704,7.93152574 10.4363051,8.16012531 L10.7284767,11.4141522 C10.7642913,11.8185976 10.3420562,12.1148978 9.95469326,11.9566366 L6.84259473,10.6826336 C6.6239373,10.5929522 6.3760627,10.5929522 6.15740527,10.6826336 Z"
                />
              </svg>
            </div>
          </div>

          <div style="display:flex">
            <div style="margin-right:3px">
              <div class="desc-star" v-if="bookDetaile.score>=5">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="13"
                  height="12"
                  viewBox="0 0 13 12"
                  color="rgb(214, 186, 140)"
                >
                  <path
                    fill="currentColor"
                    fill-rule="evenodd"
                    d="M6.15740527,10.6826336 L3.04530674,11.9566366 C2.65794378,12.1148978 2.23570873,11.8185976 2.27246579,11.4141522 L2.56463737,8.16012531 C2.58537213,7.93152574 2.50903052,7.7038054 2.35257736,7.53059727 L0.136785824,5.06348041 C-0.13842095,4.75662945 0.0227446608,4.27744959 0.431784867,4.18600976 L3.72484127,3.44833654 C3.95669356,3.39646203 4.15650121,3.2566646 4.27996727,3.05971728 L6.02262934,0.261131044 C6.2394018,-0.0870436812 6.76154068,-0.0870436812 6.97831314,0.261131044 L8.72097522,3.05971728 C8.84349879,3.2566646 9.04330644,3.39646203 9.27515873,3.44833654 L12.5682151,4.18600976 C12.9772553,4.27744959 13.138421,4.75662945 12.8632142,5.06348041 L10.6474226,7.53059727 C10.491912,7.7038054 10.4155704,7.93152574 10.4363051,8.16012531 L10.7284767,11.4141522 C10.7642913,11.8185976 10.3420562,12.1148978 9.95469326,11.9566366 L6.84259473,10.6826336 C6.6239373,10.5929522 6.3760627,10.5929522 6.15740527,10.6826336 Z"
                  />
                </svg>
              </div>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="13"
                height="12"
                viewBox="0 0 13 12"
                color="rgb(242, 242, 242)"
              >
                <path
                  fill="currentColor"
                  fill-rule="evenodd"
                  d="M6.15740527,10.6826336 L3.04530674,11.9566366 C2.65794378,12.1148978 2.23570873,11.8185976 2.27246579,11.4141522 L2.56463737,8.16012531 C2.58537213,7.93152574 2.50903052,7.7038054 2.35257736,7.53059727 L0.136785824,5.06348041 C-0.13842095,4.75662945 0.0227446608,4.27744959 0.431784867,4.18600976 L3.72484127,3.44833654 C3.95669356,3.39646203 4.15650121,3.2566646 4.27996727,3.05971728 L6.02262934,0.261131044 C6.2394018,-0.0870436812 6.76154068,-0.0870436812 6.97831314,0.261131044 L8.72097522,3.05971728 C8.84349879,3.2566646 9.04330644,3.39646203 9.27515873,3.44833654 L12.5682151,4.18600976 C12.9772553,4.27744959 13.138421,4.75662945 12.8632142,5.06348041 L10.6474226,7.53059727 C10.491912,7.7038054 10.4155704,7.93152574 10.4363051,8.16012531 L10.7284767,11.4141522 C10.7642913,11.8185976 10.3420562,12.1148978 9.95469326,11.9566366 L6.84259473,10.6826336 C6.6239373,10.5929522 6.3760627,10.5929522 6.15740527,10.6826336 Z"
                />
              </svg>
            </div>
          </div>

          <div style="display:flex">
            <div style="margin-right:3px">
              <div class="desc-star" v-if="bookDetaile.score>=7">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="13"
                  height="12"
                  viewBox="0 0 13 12"
                  color="rgb(214, 186, 140)"
                >
                  <path
                    fill="currentColor"
                    fill-rule="evenodd"
                    d="M6.15740527,10.6826336 L3.04530674,11.9566366 C2.65794378,12.1148978 2.23570873,11.8185976 2.27246579,11.4141522 L2.56463737,8.16012531 C2.58537213,7.93152574 2.50903052,7.7038054 2.35257736,7.53059727 L0.136785824,5.06348041 C-0.13842095,4.75662945 0.0227446608,4.27744959 0.431784867,4.18600976 L3.72484127,3.44833654 C3.95669356,3.39646203 4.15650121,3.2566646 4.27996727,3.05971728 L6.02262934,0.261131044 C6.2394018,-0.0870436812 6.76154068,-0.0870436812 6.97831314,0.261131044 L8.72097522,3.05971728 C8.84349879,3.2566646 9.04330644,3.39646203 9.27515873,3.44833654 L12.5682151,4.18600976 C12.9772553,4.27744959 13.138421,4.75662945 12.8632142,5.06348041 L10.6474226,7.53059727 C10.491912,7.7038054 10.4155704,7.93152574 10.4363051,8.16012531 L10.7284767,11.4141522 C10.7642913,11.8185976 10.3420562,12.1148978 9.95469326,11.9566366 L6.84259473,10.6826336 C6.6239373,10.5929522 6.3760627,10.5929522 6.15740527,10.6826336 Z"
                  />
                </svg>
              </div>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="13"
                height="12"
                viewBox="0 0 13 12"
                color="rgb(242, 242, 242)"
              >
                <path
                  fill="currentColor"
                  fill-rule="evenodd"
                  d="M6.15740527,10.6826336 L3.04530674,11.9566366 C2.65794378,12.1148978 2.23570873,11.8185976 2.27246579,11.4141522 L2.56463737,8.16012531 C2.58537213,7.93152574 2.50903052,7.7038054 2.35257736,7.53059727 L0.136785824,5.06348041 C-0.13842095,4.75662945 0.0227446608,4.27744959 0.431784867,4.18600976 L3.72484127,3.44833654 C3.95669356,3.39646203 4.15650121,3.2566646 4.27996727,3.05971728 L6.02262934,0.261131044 C6.2394018,-0.0870436812 6.76154068,-0.0870436812 6.97831314,0.261131044 L8.72097522,3.05971728 C8.84349879,3.2566646 9.04330644,3.39646203 9.27515873,3.44833654 L12.5682151,4.18600976 C12.9772553,4.27744959 13.138421,4.75662945 12.8632142,5.06348041 L10.6474226,7.53059727 C10.491912,7.7038054 10.4155704,7.93152574 10.4363051,8.16012531 L10.7284767,11.4141522 C10.7642913,11.8185976 10.3420562,12.1148978 9.95469326,11.9566366 L6.84259473,10.6826336 C6.6239373,10.5929522 6.3760627,10.5929522 6.15740527,10.6826336 Z"
                />
              </svg>
            </div>
          </div>

          <div style="display:flex">
            <div style="margin-right:3px">
              <div style="position:absolute;widht:3.9px" v-if="bookDetaile.score>=9">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="13"
                  height="12"
                  viewBox="0 0 13 12"
                  color="rgb(214, 186, 140)"
                >
                  <path
                    fill="currentColor"
                    fill-rule="evenodd"
                    d="M6.15740527,10.6826336 L3.04530674,11.9566366 C2.65794378,12.1148978 2.23570873,11.8185976 2.27246579,11.4141522 L2.56463737,8.16012531 C2.58537213,7.93152574 2.50903052,7.7038054 2.35257736,7.53059727 L0.136785824,5.06348041 C-0.13842095,4.75662945 0.0227446608,4.27744959 0.431784867,4.18600976 L3.72484127,3.44833654 C3.95669356,3.39646203 4.15650121,3.2566646 4.27996727,3.05971728 L6.02262934,0.261131044 C6.2394018,-0.0870436812 6.76154068,-0.0870436812 6.97831314,0.261131044 L8.72097522,3.05971728 C8.84349879,3.2566646 9.04330644,3.39646203 9.27515873,3.44833654 L12.5682151,4.18600976 C12.9772553,4.27744959 13.138421,4.75662945 12.8632142,5.06348041 L10.6474226,7.53059727 C10.491912,7.7038054 10.4155704,7.93152574 10.4363051,8.16012531 L10.7284767,11.4141522 C10.7642913,11.8185976 10.3420562,12.1148978 9.95469326,11.9566366 L6.84259473,10.6826336 C6.6239373,10.5929522 6.3760627,10.5929522 6.15740527,10.6826336 Z"
                  />
                </svg>
              </div>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="13"
                height="12"
                viewBox="0 0 13 12"
                color="rgb(242, 242, 242)"
              >
                <path
                  fill="currentColor"
                  fill-rule="evenodd"
                  d="M6.15740527,10.6826336 L3.04530674,11.9566366 C2.65794378,12.1148978 2.23570873,11.8185976 2.27246579,11.4141522 L2.56463737,8.16012531 C2.58537213,7.93152574 2.50903052,7.7038054 2.35257736,7.53059727 L0.136785824,5.06348041 C-0.13842095,4.75662945 0.0227446608,4.27744959 0.431784867,4.18600976 L3.72484127,3.44833654 C3.95669356,3.39646203 4.15650121,3.2566646 4.27996727,3.05971728 L6.02262934,0.261131044 C6.2394018,-0.0870436812 6.76154068,-0.0870436812 6.97831314,0.261131044 L8.72097522,3.05971728 C8.84349879,3.2566646 9.04330644,3.39646203 9.27515873,3.44833654 L12.5682151,4.18600976 C12.9772553,4.27744959 13.138421,4.75662945 12.8632142,5.06348041 L10.6474226,7.53059727 C10.491912,7.7038054 10.4155704,7.93152574 10.4363051,8.16012531 L10.7284767,11.4141522 C10.7642913,11.8185976 10.3420562,12.1148978 9.95469326,11.9566366 L6.84259473,10.6826336 C6.6239373,10.5929522 6.3760627,10.5929522 6.15740527,10.6826336 Z"
                />
              </svg>
            </div>
          </div>

          <svg
            viewBox="0 0 24 24"
            fill="none"
            stroke="rgb(210, 210, 210)"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            xmlns="http://www.w3.org/2000/svg"
            class="Icon"
          >
            <polyline points="9 18 15 12 9 6" />
          </svg>
        </div>
      </div>

      <div class="self">
        <span class="douban-set">
          <svg xmlns="http://www.w3.org/2000/svg" width="17" height="16" viewBox="0 0 17 16">
            <path
              fill="none"
              stroke="#D6BA8C"
              stroke-linecap="round"
              stroke-linejoin="round"
              d="M10.535 5.9V3.1c0-1.16-.955-2.1-2.133-2.1L5.556 7.3V15h8.024c.71.008 1.316-.5 1.422-1.19l.982-6.3a1.385 1.385 0 0 0-.333-1.129 1.433 1.433 0 0 0-1.09-.481h-4.026zM5.556 15H3.423A1.411 1.411 0 0 1 2 13.6V8.7c0-.773.637-1.4 1.423-1.4h2.133V15z"
            />
          </svg>
          <router-link class="self-desc" to="/support/book-service">多抓鱼自营 ‧ 正版保证 ‧ 消毒翻新</router-link>
          <svg
            viewBox="0 0 24 24"
            fill="none"
            stroke="rgb(210, 210, 210)"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            xmlns="http://www.w3.org/2000/svg"
            class="Icon"
          >
            <polyline points="9 18 15 12 9 6" />
          </svg>
        </span>
      </div>

      <div class="introduce">
        <div class="intro">
          <h2 class="intro-header" style="margin-bottom: 8px;">简介和目录</h2>
          <div>
            <div
              style="overflow : hidden;text-overflow: ellipsis;display:-webkit-box;-webkit-box-orient: vertical;"
              :style="showMore ? '' : '-webkit-line-clamp: 4'"
            >
              <div class="intro-content">
                <div style="text-align: left;user-select: initial;">{{bookDetaile.summary}}</div>
              </div>
            </div>

            <div class="findMore">
              <div class="tofind" @click="showMore = !showMore">
                {{showMore ? '收起' : '查看更多'}}
                <svg
                  v-if="!showMore"
                  viewBox="0 0 24 24"
                  fill="none"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  xmlns="http://www.w3.org/2000/svg"
                  class="Icon"
                >
                  <polyline points="6 9 12 15 18 9" />
                </svg>
                <svg
                  v-if="showMore"
                  viewBox="0 0 24 24"
                  fill="none"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  xmlns="http://www.w3.org/2000/svg"
                  class="Icon"
                >
                  <polyline points="18 15 12 9 6 15" />
                </svg>
              </div>
            </div>
          </div>
        </div>

        <div class="correlation">
          <h2 class="conrrelation-header">相关推荐</h2>

          <div class="correlation-list">
            <div style="padding: 20px 5px 0px;margin: -10px;">
              <router-link
                :to="{path:'/detaile',query:{bookId:book.bookId}}"
                class="list-cover"
                v-for="(book,index) in books"
                :key="index"
              >
                <div class="cover-set" @click="checkBook(book)">
                  <div class="cover-content">
                    <img :src="'https://images.weserv.nl/?url='+book.pic" class="cover-img" />
                  </div>
                  <div class="cor-bookname">{{book.title}}</div>
                </div>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="fixed">
      <div class="fixed-content">
        <router-link to="/" class="home">
          <svg viewBox="0 0 46 46" width="23" height="23" fill="rgb(102, 102, 102)">
            <path
              d="M40.408626,19.0936037 C41.5142794,19.0936037 41.7818872,18.4605103 40.999899,17.6798584 C40.999899,17.6798584 40.2374609,16.8932902 39.3786323,16.1092182 L28.307135,6.00143742 C25.3835998,3.33238081 20.5250347,3.33332761 17.6025366,6.00143742 L6.53103934,16.1092182 C5.27063301,17.2599127 4.94536401,17.5976819 4.94536401,17.5976819 C4.15404803,18.3630748 4.40272061,18.9835484 5.51069352,18.9835484 L8.12933604,18.9835484 L8.12933604,38.9782179 C8.12933604,40.6506196 9.44018899,42 11.0589093,42 L15.1960178,42 L15.1960178,36.1142596 C15.1960178,33.3521692 17.3690855,31.1184079 20.0602903,31.1184079 L25.9028188,31.1184079 C28.5876179,31.1184079 30.7670913,33.3503112 30.7670913,36.1142596 L30.7670913,42 L34.4156598,42 C36.0394895,42 37.3452331,40.6533202 37.3452331,38.9782179 L37.3452331,19.0936037 L40.408626,19.0936037 Z M28.9248518,45 L17.5567028,45 L11.0589093,45 C7.82972191,45 5.21194826,42.3082595 5.21194826,38.9782179 L5.21194826,21.9835484 C-0.845715653,22.0536625 0.249139206,17.8325867 4.5941418,13.8657941 L15.665639,3.75801332 C19.6913513,0.0827185006 26.2138163,0.0786065279 30.2440326,3.75801332 L41.3155298,13.8657941 C45.7999206,17.9598419 47.0068349,21.9607063 40.2626209,22.0536625 L40.2626209,38.9782179 C40.2626209,42.3039563 37.6567593,45 34.4156598,45 L28.9248518,45 Z M27.8497036,42 L27.8497036,36.1142596 C27.8497036,35.0088943 26.9780536,34.1184079 25.9028188,34.1184079 L20.0602903,34.1184079 C18.9774371,34.1184079 18.1134056,35.0119812 18.1134056,36.1142596 L18.1134056,42 L27.8497036,42 Z"
            />
          </svg>
        </router-link>
        <router-link to="/cart" class="cart">
          <svg viewBox="0 0 46 46" width="23" height="23" fill="rgb(102, 102, 102)">
            <path
              d="M5.13634582,14.9000848 C4.99035474,14.4862269 4.60514195,12.5971561 3.75482474,7.77983331 C2.83501781,3.52910793 4.43253177,0.5 8.76864821,0.5 L20.2546528,0.5 C21.0831633,0.5 21.7548039,1.17157288 21.7548039,2 C21.7548039,2.82842712 21.0831633,3.5 20.2546528,3.5 L8.76864821,3.5 C6.67624454,3.5 6.12473309,4.54574216 6.69830817,7.2015831 C6.81046467,7.83616231 6.91540462,8.42422373 7.01338927,8.96769281 C8.25306859,7.72925282 10.0046811,6.97740113 12.0370705,6.97740113 L33.2099771,6.97740113 C37.6256869,6.97740113 40.715656,10.5215446 40.1103966,14.9022962 L38.5838965,25.9508111 C37.9791832,30.3276098 33.9027269,33.8757062 29.4825248,33.8757062 L15.7645229,33.8757062 C11.3426874,33.8757062 7.26841058,30.3315627 6.66315116,25.9508111 L5.13665105,14.9022962 C5.1365492,14.901559 5.13644746,14.9008219 5.13634582,14.9000848 Z M10.5160122,46.5 C7.63321442,46.5 5.29950051,44.1540314 5.29950051,41.2641243 C5.29950051,38.3742171 7.63321442,36.0282486 10.5160122,36.0282486 C13.3988099,36.0282486 15.7325238,38.3742171 15.7325238,41.2641243 C15.7325238,44.1540314 13.3988099,46.5 10.5160122,46.5 Z M10.5160122,43.5 C11.738193,43.5 12.7322217,42.5007515 12.7322217,41.2641243 C12.7322217,40.0274971 11.738193,39.0282486 10.5160122,39.0282486 C9.29383135,39.0282486 8.29980262,40.0274971 8.29980262,41.2641243 C8.29980262,42.5007515 9.29383135,43.5 10.5160122,43.5 Z M36.2175797,46.5 C33.334782,46.5 31.0010681,44.1540314 31.0010681,41.2641243 C31.0010681,38.3742171 33.334782,36.0282486 36.2175797,36.0282486 C39.1003775,36.0282486 41.4340914,38.3742171 41.4340914,41.2641243 C41.4340914,44.1540314 39.1003775,46.5 36.2175797,46.5 Z M36.2175797,43.5 C37.4397606,43.5 38.4337893,42.5007515 38.4337893,41.2641243 C38.4337893,40.0274971 37.4397606,39.0282486 36.2175797,39.0282486 C34.9953989,39.0282486 34.0013702,40.0274971 34.0013702,41.2641243 C34.0013702,42.5007515 34.9953989,43.5 36.2175797,43.5 Z M9.63522588,25.540262 C10.0351674,28.434962 12.839098,30.8757062 15.7645229,30.8757062 L29.4825248,30.8757062 C32.4053871,30.8757062 35.2122993,28.4319287 35.6118218,25.540262 L37.1383219,14.491747 C37.4943309,11.9150223 35.8065182,9.97740113 33.2099771,9.97740113 L12.0370705,9.97740113 C9.44255541,9.97740113 7.75307191,11.9175926 8.10872577,14.491747 L9.63522588,25.540262 Z"
            />
          </svg>
          <span class="cart-count">{{userCart.length}}</span>
        </router-link>
        <div class="intoCart">
          <span
            @click="intoCart()"
            v-if="!cartBook && appearances.length == 1"
            class="cart-unexistence"
          >加入购物车</span>
          <span class="cart-existence" v-if="cartBook && appearances.length == 1">已加入购物车</span>
          <span
            class="stock-unexistence"
            @click="intoCart()"
            v-if="!cartBook && appearances.length == 0"
          >到货提醒</span>
          <span
            class="cart-existence-appearances"
            @click="delCartBook()"
            v-if="cartBook && appearances.length == 0"
          >取消到货提醒</span>
          <span
            class="appearances"
            @click="showAppearances = true"
            v-if="appearances.length > 1 && !cartBook"
          >多个品相可选</span>
          <van-popup v-model="showAppearances" position="bottom" class="appearances-choose">
            <div class="title">
              <span class="title-name">{{bookDetaile.title}}</span>
              <div class="appearances-rule">
                <span>多个品相的书可以购买</span>
                <span class="appearances-showRules">
                  不同品相有何区别？
                  <svg
                    viewBox="0 0 24 24"
                    fill="none"
                    stroke="rgb(170, 170, 170)"
                    stroke-width="2"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    xmlns="http://www.w3.org/2000/svg"
                    width="18px"
                  >
                    <polyline points="9 18 15 12 9 6" />
                  </svg>
                </span>
              </div>
            </div>
            <div class="appearances-list">
              <div
                class="appearances-content"
                :class="choosAppearance == el.appearance ? 'select':''"
                v-for="(el,index) in appearances"
                :key="index"
                @click="choosAppearance = el.appearance"
              >
                <span class="price">￥{{parseInt(el.price).toFixed(2)}}</span>
                <span
                  class="appearances-text"
                  :class="el.appearance == appearance_new ? 'new':''"
                >{{el.appearance == appearance_new ? "全新品" : el.appearance == appearance_good ? "品相良好" : "品相中等"}}</span>
              </div>
            </div>
            <div class="choose" @click="intoCart()">确定</div>
          </van-popup>
          <span
            class="cart-existence-appearances"
            v-if="appearances.length > 1 && cartBook"
            @click="showAppearances = true"
          >已选:{{choosAppearance == appearance_new ? "全新品" : choosAppearance == appearance_good ? "品相良好" : "品相中等"}}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Axios from "axios";

const appearance_new = 0;
const appearance_good = 1;
const appearance_secondary = 2;
const appearance_bad = 3;

export default {
  data() {
    return {
      bookId: "",
      bookDetaile: "",
      books: [],
      discount: [],
      content: false,
      showMore: false,

      cartBook: "",
      userCart: [],
      appearances: [],
      choosAppearance: "",
      showAppearances: false,

      appearance_new,
      appearance_good,
      appearance_secondary,
      appearance_bad
    };
  },
  methods: {
    checkBook(book) {
      this.$router.push({
        path: "/remarkdetails",
        query: {
          bookId: book.bookId
        }
      });
    },
    getBookInfo() {
      return Axios.get("/warehouse/bookInfo/" + this.bookId);
    },
    getBookList() {
      return Axios.get("/warehouse/recommend?bookId=" + this.bookId);
    },
    async getCart() {
      await Axios.get("/cart/selling").then(res => {
        if (res.data.data) {
          this.userCart = res.data.data;
        }
      });
    },
    async getCartBook() {
      await Axios.get("/cart/" + this.bookId).then(res => {
        if (res.data.data) {
          this.cartBook = res.data.data;
          this.choosAppearance = res.data.data.appearance;
        }
      });
    },
    async delCartBook() {
      await Axios.delete("/cart/" + this.bookId).then(res => {
        this.cartBook = "";
      });
    },
    getBookAppearances() {
      return Axios.get("/warehouse/books/" + this.bookId);
    },
    intoCart() {
      if (!localStorage.getItem("token")) {
        this.$router.push({ path: "/Authorize" });
        return;
      }
      let requestData = this.$qs.stringify({
        bookId: this.bookId,
        appearance: this.choosAppearance,
        selection: 2
      });
      Axios({
        method: this.cartBook ? "patch" : "post",
        url: "/cart",
        data: requestData
      }).then(res => {
        this.getCartBook();
        this.getCart();
      });
      this.showAppearances = false;
    }
  },
  created() {
    this.bookId = this.$route.query.bookId;
    Axios.all([
      this.getBookInfo(),
      this.getBookList(),
      this.getBookAppearances()
    ]).then(
      Axios.spread((info, list, bookAppearances) => {
        this.bookDetaile = info.data.data;
        this.choosAppearance = info.data.data.appearance;
        this.books = list.data.data;
        bookAppearances.data.data.forEach(book => {
          if (book.stock > 0) {
            console.info(book);
            this.choosAppearance = book.appearance;
            this.appearances.push({
              appearance: book.appearance,
              price: book.price,
              stock: book.stock
            });
          }
        });
      })
    );
    this.getCartBook();
    this.getCart();
  }
};
</script>
<style lang="scss">
@import "../../assets/scss/home/Detailes.scss";
</style>
