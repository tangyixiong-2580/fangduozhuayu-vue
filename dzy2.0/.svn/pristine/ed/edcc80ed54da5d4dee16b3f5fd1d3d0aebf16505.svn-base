<template>
  <div id="rootr">
    <div class="header">
      <div class="header-buy" @click="tobuy()" v-bind:class="shows==1 ? 'colors': ''">
        <div class="buy-bot" v-bind:class="shows==1 ? 'bottem': ''">买书</div>
      </div>
      <div class="header-sell" @click="tosell() ;send()" v-bind:class="shows==2 ? 'colors': ''">
        <div class="sell-bot" v-bind:class="shows==2 ? 'bottem': ''">卖书</div>
      </div>
    </div>

    <div class="type">
      <div id="wrapper">
        <el-collapse v-model="activeNames" @change="handleChange">
          <el-collapse-item title="书会消毒吗？" name="1">
            <div style="font-size:15px">多抓鱼对上架售卖的书均进行清理、翻新、消毒和包装。</div>
          </el-collapse-item>
          <el-collapse-item title="品相如何？" name="2">
            <div style="font-size:15px">目前包括全新、良品、中品三个等级。良品总体较新，有轻微使用痕迹；中品是有明显使用痕迹或无法修复的瑕疵或问题。</div>
            <div style="font-size:15px;color: rgb(24, 195, 170);">
              不同品相显示例
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
                <polyline points="9 18 15 12 9 6" />
              </svg>
            </div>
          </el-collapse-item>
          <el-collapse-item title="何时发货？" name="3">
            <div style="font-size:15px">17:00 前下单的当天发货，17:00 后下单的第二天发货。发货后，会通过多抓鱼公众号推送物流信息。</div>
          </el-collapse-item>
          <el-collapse-item title="使用什么快递？" name="4">
            <div style="font-size:15px">统一使用中通快递，部分地区中通无法配送的会切换至 EMS / 顺丰，具体以发货通知显示的为准。暂不支持自选快递。</div>
          </el-collapse-item>

          <el-collapse-item title="多久送达？" name="5">
            <div style="font-size:15px">根据不同地区距离多抓鱼仓库的远近，中通快递一般时效为 2-5 天，顺丰 / EMS 为 1-3 天，具体以实际情况为准。</div>
          </el-collapse-item>

          <el-collapse-item title="运费怎么算？" name="6">
            <div style="font-size:15px">
              满 99 元免运费。基础运费 5 元。
              偏远地区（甘肃、内蒙古、宁夏、青海、海南、新疆、西藏）：
              满 199 元免运费。基础运费 10 元，超过 3 本，每本增加 1.6 元运费。
            </div>
          </el-collapse-item>

          <el-collapse-item title="运费参与哪些优惠？" name="7">
            <div style="font-size:15px">买书包邮券可以减免运费。运费不参与买书抵扣券和满减券的优惠；不参与余额支付的优惠。</div>
          </el-collapse-item>

          <el-collapse-item title="买书订单可以取消吗？取消后如何退款？" name="8">
            <div
              style="font-size:15px"
            >在商品拣货前可以取消，开始拣货后无法取消。订单取消后，款项将原路退回。每天能取消的次数不超过 5 次（包括未支付、已支付和 30 分钟锁定期被动取消）。</div>
          </el-collapse-item>

          <el-collapse-item title="可以退换货吗？" name="9">
            <div
              style="font-size:15px"
            >非品相或质量问题，不可以退换货。多抓鱼提供的是循环服务，会对所有出库书籍进行翻新、消毒、再包装。因服务造成的品相不达标或其他质量问题，请在收到书的 15 日内联系客服退款处理。如订单超出 15 日售后时效，则无法申请售后。如有疑问，请与客服联系。</div>
          </el-collapse-item>

          <el-collapse-item title="到货提醒按什么规则发送？" name="10">
            <div
              style="font-size:15px"
            >每次有书上架时都会给标记过这本书「到货提醒」的用户发通知。当一本书被太多人标记了「到货提醒」时，通知是无法做到同时发送给所有人的。如果在发送过程中这本书已经被买走了，就不会继续给余下的人发送了，这会导致有时候书到货了却有部分用户没收到通知的情况。我们会用公平的轮换机制去安排每次书到货时的通知发送顺序。</div>
          </el-collapse-item>

          <el-collapse-item title="书的收购价格是如何确定的？" name="11">
            <div style="font-size:15px">图书价格会根据库存和市场情况动态调整，扫码后可获得该本书当前的预估收购价。</div>
          </el-collapse-item>

          <el-collapse-item title="什么书不收？" name="12">
            <div
              style="font-size:15px"
            >扫码提示不收或在安排快递前线上审核显示拒绝的就是暂时不收的。有影响阅读及封面完整和美观的破损、污渍、老化、异味；非卖品和非法出版物。</div>
          </el-collapse-item>

          <el-collapse-item title="品相会影响收购价吗？" name="13">
            <div
              style="font-size:15px"
            >多抓鱼在收到书时会进行品相审核，这一步会把书籍的品相分为全新、品相良好、品相中等、品相不合格，其中品相中等的收购价比全新和品相良好的要低 20%，品相不合格的书会被拒收。</div>
            <div style="font-size:15px;color: rgb(24, 195, 170);">
              品相审核分级细则
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
                <polyline points="9 18 15 12 9 6" />
              </svg>
            </div>
          </el-collapse-item>

          <el-collapse-item title="如何卖书？" name="14">
            <div style="font-size:15px">扫描书背面的 ISBN 码或手动输入书的 ISBN 号，扫码书籍达到收购数量后，提交卖书订单。</div>
          </el-collapse-item>

          <el-collapse-item title="不经过扫码和下单，可以直接寄书过来卖吗？" name="15">
            <div
              style="font-size:15px"
            >强烈建议你把想卖的书扫码下单后再寄出，如果你把没有扫码的书直接寄过来，多抓鱼不一定会收这本书，并且也不能保证可以取回，请尽量走扫码流程卖书给多抓鱼哦。</div>
          </el-collapse-item>

          <el-collapse-item title="如何收到卖书的钱？" name="16">
            <div
              style="font-size:15px"
            >快递签收后，我们会在 1-3 天内完成书籍的审核与打款。审核后，除去未收到的书以及审核拒绝的书，其余书费将即刻到你的多抓鱼账户，可以随时提现到微信零钱包或用来购买多抓鱼的其他商品。春节、促销活动等审核紧张时期，审核时间可能会延长，具体延时会在下单前通知。</div>
          </el-collapse-item>

          <el-collapse-item title="卖书订单可否取消？" name="17">
            <div style="font-size:15px">在顺丰或京东上门取货前，可以取消。已经在运送途中的卖书订单，不能取消。</div>
          </el-collapse-item>

          <el-collapse-item title="卖书的物流费用谁承担？" name="18">
            <div style="font-size:15px">卖书运费全部由多抓鱼承担，多抓鱼会安排顺丰或京东上门取件，选择「到付」即可。</div>
          </el-collapse-item>

          <el-collapse-item title="审核后被拒绝的书如何处理？" name="19">
            <div
              style="font-size:15px"
            >审核被拒绝的书籍不会再上架销售。收到拒书通知后 72 小时内可在卖书订单中申请取回，首次拒书取回免费，之后需支付运费取回。异常订单或异常用户的拒书，不享受首次免费取回服务。不想取回或者 72 小时内未申请取回的，将统一处理。</div>
          </el-collapse-item>

          <el-collapse-item title="卖书的实际收入与预计收入有差别？" name="20">
            <div
              style="font-size:15px"
            >多抓鱼会在收到书之后进行人工审核，包括确定书的原价，品相是否满足要求，是否有多寄、少寄、错寄等情况，以上均可能影响实际收入。如对审核结果有疑问，可在卖书订单完成后的 15 日内联系客服处理。对被拒绝的书有疑问则需在 72 小时的取回时效内联系客服处理。</div>
          </el-collapse-item>

          <el-collapse-item title="收购杂志吗？" name="21">
            <div
              style="font-size:15px"
            >目前开放 5 种杂志的收购：《三联生活周刊》（2003 年以后）、《新视线》（2009 年以后）、《新知》、《中国国家地理》、《博物》，同一种杂志的每一期使用统一收购价，收购价可在扫码后获得。对于不在收购范围内的杂志，多抓鱼不会打款，也暂时不支持取回，请确认寄出的杂志在收购范围内。</div>
          </el-collapse-item>

          <el-collapse-item title="多抓鱼用户协议" name="22">
            <div style="font-size:15px">无数据</div>
          </el-collapse-item>

          <el-collapse-item title="营业执照 · 经营许可" name="23">
            <div style="font-size:15px">无数据</div>
          </el-collapse-item>
        </el-collapse>
      </div>
    </div>
  </div>
</template>

<script>
import BScroll from "better-scroll";
export default {
  data() {
    return {
      activeNames: ["0"],
      shows: 1,
      moves: true,
      pos: 0
    };
  },
  methods: {
    handleChange(val) {
    },
    tobuy() {
      if (this.shows == 2) {
        this.shows = 1;
      }
      this.$nextTick(() => {
        var container = this.$el.querySelector("#wrapper");
        container.scrollTop = 0;
      });
    },
    tosell() {
      if (this.shows == 1) {
        this.shows = 2;
      }
    },
    // 获取滚动条与顶端距离
    scroll(event) {
      this.pos = event.target.scrollTop;
    },
    send() {
      this.$nextTick(() => {
        var container = this.$el.querySelector("#wrapper");
        container.scrollTop = 820;
      });
    },
    move() {
      if (
        this.$nextTick(() => {
          var container = this.$el.querySelector("#wrapper");
          container.scrollTop > 820;
        })
      ) {
        this.moves = false;
      }
    }
  }
};
</script>

<style lang="scss">
@import '../../assets/scss/support/problems.scss';

.el-collapse {
  .el-collapse-item__header {
    padding: 10px 0px;
    font-size: 16px;
  }
}
</style>
