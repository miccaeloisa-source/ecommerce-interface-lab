async function fetchProducts() {

    try {

        const response = await fetch("http://localhost:8080/api/v1/products");

        if (!response.ok) {
            throw new Error("Failed to fetch products");
        }

        const products = await response.json();

        const productGrid = document.querySelector(".product-grid");

        productGrid.innerHTML = "";

        if(products.length === 0){

            productGrid.innerHTML = `
                <h2>No products available</h2>
            `;

            return;
        }

        products.forEach(product => {

            productGrid.innerHTML += `

                <div class="product-card">

                    <img 
                        src="images/${product.imageUrl}" 
                        alt="${product.name}"
                    >

                    <h3>${product.name}</h3>

                    <p>${product.description}</p>

                    <h4>₱${product.price}</h4>

                    <p>Stock: ${product.stock}</p>

                    <button>Add to Cart</button>

                </div>

            `;

        });

    } catch(error) {

        console.error("Fetch Error:", error);

    }

}

fetchProducts();