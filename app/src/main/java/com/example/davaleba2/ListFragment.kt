import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.davaleba2.ProfileFragment

class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val gotoHomeButton = view.findViewById<Button>(R.id.button_goto_home)
        gotoHomeButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val gotoProfileButton = view.findViewById<Button>(R.id.button_goto_profile)
        gotoProfileButton.setOnClickListener {
            val profileFragment = ProfileFragment()
            profileFragment.arguments = arguments
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, profileFragment).commit()
        }

        return view
    }
}
