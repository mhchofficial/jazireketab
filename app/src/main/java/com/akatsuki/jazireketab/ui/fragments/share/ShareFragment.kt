package com.akatsuki.jazireketab.ui.fragments.share

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akatsuki.jazireketab.MainActivity
import com.akatsuki.jazireketab.databinding.FragmentShareBinding
import com.akatsuki.jazireketab.ui.fragments.categories.viewmodels.CatViewModel
import com.akatsuki.jazireketab.utils.Constant.APP_LINK
import com.akatsuki.jazireketab.utils.Constant.TELEGRAM_PAGE_ID

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShareFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShareFragment : Fragment() {
    private var _binding: FragmentShareBinding? = null
    private val binding get() = _binding!!

    private var param1: String? = null
    private var param2: String? = null


    private var viewModel: CatViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShareBinding.inflate(inflater, container, false)
        val view = binding.root
        (activity as MainActivity).hideActionbarFr()
        (activity as MainActivity).updatetitle("ارسال به دوستان")
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true);
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true);


        binding.sharetelegram.setOnClickListener {

            try {
                try {
                    context?.packageManager?.getPackageInfo("org.telegram.messenger", 0)//Check for Telegram Messenger App
                } catch (e : Exception){
                    context?.packageManager?.getPackageInfo("org.thunderdog.challegram", 0)//Check for Telegram X App
                }
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain=${TELEGRAM_PAGE_ID}"))
                startActivity(intent);
            }catch (e : Exception){ //App not found open in browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.telegram.me/$TELEGRAM_PAGE_ID"))
                startActivity(intent);
            }
        }

        binding.shareapps.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_SEND)
            sendIntent.type = "text/plain"
            sendIntent.putExtra(Intent.EXTRA_TEXT, APP_LINK)
            startActivity(sendIntent)
        }




        return view.rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShareFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShareFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}