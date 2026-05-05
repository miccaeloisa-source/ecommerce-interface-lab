package com.ws101.Arnesto.Pelito.EcommerceApi.service;

// ... imports remain the same

/**
 * Service class that manages the business logic for Products.
 * Handles in-memory data storage and unique ID generation.
 */
@Service
public class ProductService {
    private final List<Product> productList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    /**
     * Constructor that initializes the service with 10 sample products.
     */
    public ProductService() {
        // ... (your productList.add code here)
    }

    /**
     * Gets all products currently stored in the in-memory list.
     * @return A list of all Product objects.
     */
    public List<Product> getAllProducts() {
        return productList;
    }

    /**
     * Searches for a product by its ID using Java Streams.
     * @param id The ID to search for.
     * @return An Optional containing the product if found.
     */
    public Optional<Product> getProductById(Long id) {
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    /**
     * Assigns a unique ID and saves a new product to the list.
     * @param product The product data to save.
     * @return The saved product with its newly assigned ID.
     */
    public Product createProduct(Product product) {
        product.setId(idCounter.getAndIncrement());
        productList.add(product);
        return product;
    }

    /**
     * Removes a product from the list if the ID matches.
     * @param id The ID of the product to remove.
     * @return true if the product was found and removed, false otherwise.
     */
    public boolean deleteProduct(Long id) {
        return productList.removeIf(p -> p.getId().equals(id));
    }
}