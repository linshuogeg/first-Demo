package com.example.usercenterq.protocol.req

data class RespGoodEntity(
    val code: Int,
    val data: List<Data>,
    val msg: String
){

    data class Data(val CategoryId: Int,
                    val CategoryName: String,
                    val CommissionRate: String,
                    val CommissionType: String,
                    val CouponAmount: Any,
                    val CouponEndTime: Any,
                    val CouponId: String,
                    val CouponInfo: String,
                    val CouponRemainCount: Int,
                    val CouponShareUrl: Any,
                    val CouponStartFee: Any,
                    val CouponStartTime: Any,
                    val CouponTotalCount: Int,
                    val Distance: Any,
                    val IncludeDxjh: String,
                    val IncludeMkt: String,
                    val InfoDxjh: String,
                    val ItemDescription: String,
                    val ItemId: Long,
                    val ItemUrl: String,
                    val JddNum: Int,
                    val JddPrice: Any,
                    val KuadianPromotionInfo: Any,
                    val LevelOneCategoryId: Int,
                    val LevelOneCategoryName: String,
                    val LockRate: Any,
                    val LockRateEndTime: Int,
                    val LockRateStartTime: Int,
                    val Nick: String,
                    val NumIid: Long,
                    val Oetime: Any,
                    val OrigPrice: Any,
                    val Ostime: Any,
                    val PictUrl: String,
                    val PresaleDeposit: String,
                    val PresaleDiscountFeeText: Any,
                    val PresaleEndTime: Int,
                    val PresaleStartTime: Int,
                    val PresaleTailEndTime: Int,
                    val PresaleTailStartTime: Int,
                    val Provcity: String,
                    val RealPostFee: String,
                    val ReservePrice: String,
                    val SaleBeginTime: Any,
                    val SaleEndTime: Any,
                    val SalePrice: Any,
                    val SellNum: Int,
                    val SellerId: Long,
                    val ShopDsr: Int,
                    val ShopTitle: String,
                    val ShortTitle: String,
                    val SmallImages: List<String>,
                    val Stock: Int,
                    val Title: String,
                    val TkTotalCommi: String,
                    val TkTotalSales: String,
                    val TmallPlayActivityInfo: Any,
                    val TotalStock: Int,
                    val Url: String,
                    val UsableShopId: Any,
                    val UsableShopName: Any,
                    val UserType: Int,
                    val UvSumPreSale: Int,
                    val Volume: Int,
                    val WhiteImage: String,
                    val XId: String,
                    val YsylClickUrl: Any,
                    val YsylCommissionRate: Any,
                    val YsylTljFace: Any,
                    val YsylTljSendTime: Any,
                    val YsylTljUseEndTime: Any,
                    val YsylTljUseStartTime: Any,
                    val ZkFinalPrice: String)
}
