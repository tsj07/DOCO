package com.example.doco.kycFragments

import android.app.Activity
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.doco.KycActivity
import com.example.doco.R
import com.example.doco.databinding.FragmentUploadAadhaarBinding

class UploadAadhaar : Fragment() {
    lateinit var binding: FragmentUploadAadhaarBinding
    private val REQUEST_CODE_GALLERY = 1
    private var cameraUri: Uri? = null
    private var galleryUri: Uri? = null
    private val REQUEST_CODE_CAMERA = 10

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUploadAadhaarBinding.inflate(inflater, container, false)
        binding.btnUpload.setOnClickListener {
            showDialog()
        }
        return binding.root
    }

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_upload)

        val openGallery = dialog.findViewById(R.id.tvGallery) as TextView
        openGallery.setOnClickListener {
            val galleryIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, REQUEST_CODE_GALLERY)
            dialog.dismiss()
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    (activity as KycActivity).changeFragment(SuccessfullyUpdated())
                }, 5000
            )
        }

        val openCamera = dialog.findViewById(R.id.tvCamera) as TextView
        openCamera.setOnClickListener {
            val cameraIntent = Intent(
                MediaStore.ACTION_IMAGE_CAPTURE
            )
            try {
                startActivityForResult(cameraIntent, REQUEST_CODE_CAMERA)
            } catch (_: ActivityNotFoundException) {
            }
            dialog.dismiss()
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    (activity as KycActivity).changeFragment(SuccessfullyUpdated())
                }, 8000
            )
        }
        dialog.show()
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE_GALLERY) {
                galleryUri = data?.data
                binding.ivPhoto.setImageURI(galleryUri)
            } else if (requestCode == REQUEST_CODE_CAMERA) {
                val cameraUri: Bitmap? = data!!.extras!!["data"] as Bitmap?
                binding.ivPhoto.setImageBitmap(cameraUri)
            }
        }
    }


//    private fun dispatchTakePictureIntent() {
//        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        try {
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
//        } catch (e: ActivityNotFoundException) {
//            // display error state to the user
//        }
//    }

}