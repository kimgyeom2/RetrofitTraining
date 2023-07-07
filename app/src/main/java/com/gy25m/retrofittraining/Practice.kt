package com.gy25m.retrofittraining

data class Practice(var item:MutableList<Pr>)

data class Pr(
    var userId:String,
    var id:String,
    var title:String,
    var completed:String
)