package com.example.imsihyun.android_server_hapdong.get

data class GetShopResponseData (
        var shop_name : String, // 가게 이름
        var shop_content : String, // 가게 설명
        var shop_image : String?, // 가게 이미지
        var review_count : Int // 가게 리뷰 점수, 서버에서 받는 key값과 동일해야됨. 명심!
)