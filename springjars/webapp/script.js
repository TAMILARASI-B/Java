document.addEventListener('DOMContentLoaded', function() {
    const orderForm = document.getElementById('order-form');
    const orderStatusSection = document.getElementById('order-status');
    const statusMessage = document.getElementById('status-message');

    orderForm.addEventListener('submit', function(event) {
        event.preventDefault();
        
        // Gather form data
        const formData = new FormData(orderForm);
        const customerName = formData.get('customer_name');
        const deliveryAddress = formData.get('delivery_address');
        const productName = formData.get('product_name');
        const quantity = formData.get('quantity');

        // Example: You can send this data to a backend server using fetch API or XMLHttpRequest
        // For demonstration, just show the order details
        statusMessage.innerHTML = `
            <p><strong>Customer Name:</strong> ${customerName}</p>
            <p><strong>Delivery Address:</strong> ${deliveryAddress}</p>
            <p><strong>Product Name:</strong> ${productName}</p>
            <p><strong>Quantity:</strong> ${quantity}</p>
            <p>Order created successfully!</p>
        `;

        orderStatusSection.style.display = 'block';
        orderForm.reset(); // Clear the form
    });
});
