package com.rich.taskintentbundleparce

import java.io.Serializable

data class DataSerializable(var umur : String,
                            var tinggi : String,
                            var berat : String,
                            var bmi : String,
                            var kategoriBmi : String) : Serializable
