import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.data.Product

@Composable
fun HomePage(onLogout: () -> Unit) {

    val context = LocalContext.current
    val PREFS_NAME = "myPrefs"
    val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    var savedEmail by remember { mutableStateOf(prefs.getString("email", "") ?: ("")) }

    var list = remember {
        mutableStateListOf(
            Product("Product 1", 10.0, "Description 1", android.R.drawable.ic_menu_camera),
            Product("Product 2", 20.0, "Description 2", android.R.drawable.ic_menu_camera),
            Product("Product 3", 30.0, "Description 3", android.R.drawable.ic_menu_camera),
            Product("Product 4", 40.0, "Description 4", android.R.drawable.ic_menu_camera),
            Product("Product 5", 50.0, "Description 5", android.R.drawable.ic_menu_camera)
        )
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Home Page!", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(list){ pro ->
                ItemComposable(product = pro)

            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onLogout()
            prefs.edit().remove("email").apply()
        }) {
            Text(text = "Logout and Return to Login")
        }
    }

}

@Composable
fun ItemComposable(modifier: Modifier = Modifier, product: Product){
    Card (
        modifier = modifier
            .padding(16.dp)
            .clickable {

            }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
           Text(text = product.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(16.dp))
            Image(
                painter = painterResource(id = product.imageUrl),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(text = "$${product.price}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}



// khalid@gmail.com

