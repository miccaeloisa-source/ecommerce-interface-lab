<<<<<<< HEAD
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
=======
class Product {
    constructor(id, name, price, image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }
}

const products = [
    new Product(1, "Lipstick and Gloss", 120, "lipstick.jpg"),
    new Product(2, "Foundation", 200, "foundation.jpg"),
    new Product(3, "Eye Shadow", 50, "eyeshadow.jpg"),
    new Product(4, "Concealer", 45, "concealer.jpg"),
    new Product(5, "Blush", 35, "blush.jpg"),
    new Product(6, "Mascara", 25, "mascara.jpg"),
    new Product(7, "Setting Powder", 40, "powder.jpg"),
    new Product(8, "Eyeliner", 20, "eyeliner.jpg"),
    new Product(9, "Highlighter", 55, "highlighter.jpg"),
    new Product(10, "Primer", 30, "primer.jpg")
];

let cart = JSON.parse(localStorage.getItem('mr_collection_cart')) || [];

function renderProductGrid() {
    const grid = document.querySelector('.product-grid');
    if (!grid) return; 

    grid.textContent = "";

    products.forEach(product => {
        const article = document.createElement('article');
        
        const img = document.createElement('img');
        img.src = product.image;
        img.alt = product.name;

        const h3 = document.createElement('h3');
        h3.textContent = product.name;

        const p = document.createElement('p');
        p.className = 'price';
        p.textContent = `$${product.price}`;

        const btn = document.createElement('button');
        btn.textContent = "Add to Cart";
        btn.setAttribute('data-id', product.id);
        btn.className = 'add-to-cart-btn';

        article.appendChild(img);
        article.appendChild(h3);
        article.appendChild(p);
        article.appendChild(btn);
        grid.appendChild(article);
    });
}

document.body.addEventListener('click', (e) => {
    if (e.target.classList.contains('add-to-cart-btn')) {
        const productId = parseInt(e.target.getAttribute('data-id'));
        const product = products.find(p => p.id === productId);
        
        if (product) {
            cart.push({...product, qty: 1});
            localStorage.setItem('mr_collection_cart', JSON.stringify(cart));
            
            const card = e.target.closest('article');
            card.classList.add('pulse'); 
            setTimeout(() => card.classList.remove('pulse'), 500);
            alert(`${product.name} added to cart!`);
        }
    }
});

function renderCartPage() {
    const cartList = document.querySelector('.cart-items ul');
    const subtotalText = document.querySelector('.cart-summary p');
    if (!cartList) return;

    cartList.textContent = "";

    cart.forEach((item, index) => {
        const li = document.createElement('li');
        li.innerHTML = `
            <h3>${item.name}</h3>
            <p>$${item.price}</p>
            <input type="number" value="${item.qty}" min="0" data-index="${index}" class="qty-update">
        `;
        cartList.appendChild(li);
    });

    const total = cart.reduce((sum, item) => sum + (item.price * item.qty), 0);
    if (subtotalText) subtotalText.textContent = `Subtotal: $${total.toFixed(2)}`;
}


const checkoutForm = document.querySelector('.shipping form');
if (checkoutForm) {
    checkoutForm.addEventListener('submit', (e) => {
        e.preventDefault();
        
        const nameInput = document.querySelector('#name');
        const streetInput = document.querySelector('#street');
        
        if (nameInput.value.trim() === "" || streetInput.value.trim() === "") {
            nameInput.classList.add('error');
            alert("Please fill in all required fields.");
        } else {
            alert("Order Successful!");
            localStorage.removeItem('mr_collection_cart');
            window.location.href = 'landing.html';
        }
    });
}


function initAccount() {
    const welcome = document.querySelector('header h1');
    if (welcome && window.location.pathname.includes('account')) {
        welcome.textContent = "Welcome, Alex Rivera";
    }

    const details = document.querySelector('details');
    if (details) {
        details.addEventListener('toggle', () => {
            if (details.open) {
                const p = details.querySelector('p');
                p.textContent = "Order #12345 - Status: Shipped - Total: $29.99";
            }
        });
    }
}


document.addEventListener('DOMContentLoaded', () => {
    renderProductGrid();
    renderCartPage();
    initAccount();
});
>>>>>>> 6b4d4c4a0afcdf1b6d6d9bd3a4d6239ef66b8324
