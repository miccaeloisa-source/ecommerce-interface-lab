package com.ws101.Arnesto.Pelito.EcommerceApi.controller;

// ... imports remain the same

/**
 * REST Controller that handles HTTP requests for the Product API.
 * Provides endpoints for retrieving, creating, and deleting products.
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieves a list of all products in the system.
     * @return ResponseEntity containing the list of products and HTTP 200 status.
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    /**
     * Retrieves a specific product by its unique ID.
     * @param id The ID of the product to find.
     * @return ResponseEntity with the product if found, or 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new product and adds it to the storage.
     * @param product The product object received in the request body.
     * @return ResponseEntity containing the created product and HTTP 201 status.
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * Deletes a product from the system based on the ID.
     * @param id The ID of the product to be removed.
     * @return ResponseEntity with 204 No Content if successful, or 404 if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productService.deleteProduct(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}