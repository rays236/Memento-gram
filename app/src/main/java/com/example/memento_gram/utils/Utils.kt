package com.example.memento_gram.utils

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import java.util.UUID

// Firebase Storage shits
fun uploadImage(uri: Uri,folderName: String, callback:(String?)->Unit){
    var imageUrl:String?=null
    FirebaseStorage.getInstance().getReference(folderName).child(UUID.randomUUID().toString()).putFile(uri).addOnSuccessListener{
        it.storage.downloadUrl.addOnSuccessListener{
            imageUrl=it.toString()
            callback(imageUrl)
        }
    }
}