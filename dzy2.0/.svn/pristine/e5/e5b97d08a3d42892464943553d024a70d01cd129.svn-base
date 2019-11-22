<template>
  <div class="condition">
    <!-- <div class="head">
         
        <div class="inside">
            <div class="title">
                <div class="logo">
                    <img src="https://asset.duozhuayu.com/logo_small.png" alt="" class="picture">
                    
                </div>
                <div class="theme">
                        多抓鱼其实有 App 了
                </div>
                 
            </div>
            <button class="button" style="width: 80px; height: 30px; font-size: 13px; font-weight: 500; padding: 5px;" border-radius:="15px;">打开 App</button>
        </div>
      </div>
    <div class="blank"></div>-->
    <div class="grade">
      <h1 class="examine">书籍品相审核分级细则</h1>
      <div
        class="examine_desc"
      >多抓鱼在收到书时会进行品相审核，这一步会把书籍的品相分为全新、品相良好、品相中等、品相不合格，其中品相中等的收购价比全新和品相良好的要低 20%，品相不合格的书会被拒收。</div>
      <div class="new">
        <h2 class="new_title">全新</h2>
        <div class="new_desc">在多抓鱼收到时是全新且未拆封的。</div>
      </div>
      <div class="good">
        <h2 class="good_title">品相良好</h2>
        <div class="good_desc">有不明显的使用痕迹或瑕疵（扉页/衬页存在少量文字或盖章也接受）。</div>
        <div>
          <div class="good_picture" v-if="isShow">
            <img src="../../assets/imgas/books/书籍1.jpg" alt />
            <img src="../../assets/imgas/books/书籍2.jpg" alt />
          </div>
          <!-- <div class="btn btn-default" > </div> -->
          <div class="good_case" @click="isShow = !isShow">
            {{isShow ? "收起" : "品相良好图片实例"}}
            <!-- 品相良好图片实例 -->
            <div v-if="isShow" style="    width: 1.4em;">
              <svg
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                xmlns="http://www.w3.org/2000/svg"
                class="Icon"
                style="transform: rotate(180deg);"
              >
                <polyline points="6 9 12 15 18 9" />
              </svg>
            </div>
            <div v-if="!isShow">
              <svg
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
            </div>
          </div>
        </div>
      </div>

      <div class="secondary">
        <h2 class="good_title">品相中等</h2>
        <div class="good_desc">有较明显的使用痕迹和轻度瑕疵，但不影响正常阅读。收购价比全新和品相良好要低 20%。</div>
        <div>
          <div class="unqualified_picture" v-if="aa">
            <img src="../../assets/imgas/books/中等1.png" alt />
            <div class="friction">
              <img src="../../assets/imgas/books/中等2.jpg" alt />
            </div>
            <div class="friction">
              <img src="../../assets/imgas/books/中等3.png" alt />
            </div>
            <div class="friction">
              <img src="../../assets/imgas/books/中等4.png" alt />
            </div>
            <div class="friction">
              <img src="../../assets/imgas/books/中等5.jpg" alt />
            </div>
          </div>
          <!-- <div class="btn btn-default" > </div> -->
          <div class="good_case" @click="aa = !aa">
            {{aa ? "收起" : "品相中等图片实例"}}
            <!-- 品相良好图片实例 -->
            <div v-if="aa">
              <svg
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                xmlns="http://www.w3.org/2000/svg"
                class="Icon"
                style="transform: rotate(180deg);"
              >
                <polyline points="6 9 12 15 18 9" />
              </svg>
            </div>
            <div v-if="!aa">
              <svg
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
            </div>
          </div>
        </div>
      </div>

      <div class="unqualified">
        <h2 class="good_title">品相不合格</h2>
        <div class="good_desc">书籍品相已经影响书的下一位主人的使用和阅读体验，并且无法修复时，书将被拒收（首次免费取回），不会将其上架售卖。</div>
        <div class="good_desc" v-if="bb">
          品相不合格主要包括以下几种情况：
          <div class="cc">
            <div class="stain">严重污渍：无法被清洁掉的大面积或让人产生明显不适的霉斑、油渍、水渍等；</div>
            <div
              class="stain"
            >含馆藏类印章或标签：书籍权属不明，不适宜循环售卖；如果你有能够证明权属关系的批量处理馆藏书籍的需求，请邮件联系多抓鱼 b2b 小组：b2b@duozhuayu.net</div>
            <div class="stain">严重破损：影响正常阅读的封面破损、书脊破损、内页破损或开胶脱页；</div>
            <div class="stain">划线或标注过多：导致正文辨识不清的划线或标注，和正文无关的大面积乱涂乱画；</div>
            <div class="stain">习题册已做：做题后失去使用价值；</div>
            <div class="stain">附件缺失：附件缺失后影响书籍使用和阅读，如解密卡；</div>
            <div class="stain">漏印或错印：导致书籍无法完整阅读的漏印或错印；</div>
            <div class="stain">严重变形：影响正常阅读的书籍变形；</div>
            <div class="stain">严重异味：影响正常阅读的浓重霉味或其他让人产生明显不适的气味；</div>
            <div class="stain">音像制品：磁带、光盘或以其为主体的商品。</div>
          </div>
          <div class="unqualified_picture">
            <!-- <div class="situations"> -->
            <img src="../../assets/imgas/books/不合格1.jpg" alt />
            <img src="../../assets/imgas/books/不合格2.png" alt />
            <img src="../../assets/imgas/books/不合格3.jpg" alt />
            <!-- </div> -->
          </div>
        </div>
        <div class="good_case" @click="bb = !bb">
          {{bb ? "收起" : "品相不合格图片实例"}}
          <!-- 品相良好图片实例 -->
          <div v-if="bb">
            <svg
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
              xmlns="http://www.w3.org/2000/svg"
              class="Icon"
              style="transform: rotate(180deg);"
            >
              <polyline points="6 9 12 15 18 9" />
            </svg>
          </div>
          <div v-if="!bb">
            <svg
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
          </div>
        </div>
      </div>

      <div class="reason">
        <h2 class="good_title">其他不合格原因</h2>
        <div class="good_desc">非卖品、盗版书、套装书缺册和非法出版物是会被拒收的。</div>
      </div>
    </div>
  </div>
</template>
<style lang="scss">
@import '../../assets/scss/support/condition.scss';
</style> 
 
<script>
export default {
  name: "demo",
  data() {
    return {
      isShow: false,
      aa: false,
      bb: false,
      text: "显示"
    };
  }
};
</script>