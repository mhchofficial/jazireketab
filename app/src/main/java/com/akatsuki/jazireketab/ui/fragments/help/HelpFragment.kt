package com.akatsuki.jazireketab.ui.fragments.help

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akatsuki.jazireketab.MainActivity
import com.akatsuki.jazireketab.databinding.FragmentHelpBinding
import com.akatsuki.jazireketab.utils.Constant
import com.akatsuki.jazireketab.utils.Constant.MAIL_ADR
import com.akatsuki.jazireketab.utils.Constant.NUM_HELP

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HelpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HelpFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentHelpBinding? = null
    private val binding get() = _binding!!


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
        // Inflate the layout for this fragment
        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        val view = binding.root


        (activity as MainActivity).hideActionbarFr()
        (activity as MainActivity).updatetitle("ارتباط با پشتیبانی")
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true);
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true);



        binding.helptelegram.setOnClickListener {

            try {
                try {
                    context?.packageManager?.getPackageInfo("org.telegram.messenger", 0)//Check for Telegram Messenger App
                } catch (e : Exception){
                    context?.packageManager?.getPackageInfo("org.thunderdog.challegram", 0)//Check for Telegram X App
                }
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain=${Constant.TELEGRAM_sup_ID}"))
                startActivity(intent);
            }catch (e : Exception){ //App not found open in browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.telegram.me/${Constant.TELEGRAM_sup_ID}"))
                startActivity(intent);
            }
        }

        binding.helpmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:") // only email apps should handle this

            intent.putExtra(Intent.EXTRA_EMAIL, MAIL_ADR)
            intent.putExtra(Intent.EXTRA_SUBJECT, "کمک")
            if (intent.resolveActivity(context?.packageManager!!) != null) {
                startActivity(intent)
            }
        }

        binding.helpwhatsup.setOnClickListener {
            val url = "https://api.whatsapp.com/send?phone=$NUM_HELP"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }


        return  view.rootView

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HelpFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HelpFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}