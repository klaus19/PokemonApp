import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel:ViewModel() {

    private val _stateFlow = MutableStateFlow("Hello")

    val stateFlow = _stateFlow.asStateFlow()

    //Emit the data in stateFlow
    fun updateStateFlow(){
        viewModelScope.launch {
            _stateFlow.emit("Hello World")
        }
    }
}