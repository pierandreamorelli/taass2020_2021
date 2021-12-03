import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ProductOrder} from '../models/product-order.model';
import {EcommerceService} from '../services/EcommerceService';
import {Subscription} from 'rxjs/internal/Subscription';
import {Product} from '../models/product.model';
import {faPlus, faMinus} from '@fortawesome/free-solid-svg-icons';

@Component({
    selector: 'app-products',
    templateUrl: './products.component.html',
    styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
    productOrders: ProductOrder[] = [];
    products: Product[] = [];
    selectedProductOrder: ProductOrder;
    sub: Subscription;
    productSelected = false;
    listName: string[] = [];
    faMinus = faMinus;
    faPlus = faPlus;


    constructor(public ecommerceService: EcommerceService) {

    }

    ngOnInit() {
        this.productOrders = [];
    }
    addToCart(order: ProductOrder) {
        this.ecommerceService.SelectedProductOrder = order;
        this.selectedProductOrder = this.ecommerceService.SelectedProductOrder;
        // rimozione
        this.productSelected = true;
    }

    removeFromCart(productOrder: ProductOrder) {
        const index = this.getProductIndex(productOrder.product);
        if (index > -1) {
            this.ecommerceService.ProductOrders.productOrders.splice(
                this.getProductIndex(productOrder.product), 1);
        }
        console.log(this.calculateTotal(this.ecommerceService.ProductOrders.productOrders));
        this.ecommerceService.changeTotal((this.calculateTotal(this.ecommerceService.ProductOrders.productOrders)));
       this.productSelected = false;
    }

    getProductIndex(product: Product): number {
        return this.ecommerceService.ProductOrders.productOrders.findIndex(
            value => value.product.id === product.id);
    }

    isProductSelected(product: Product): boolean {
        return this.getProductIndex(product) > -1;
    }


    loadProducts(i: number) {
        this.ecommerceService.productOrders2 = [];
        this.ecommerceService.getCategoryUrl(i)
            .subscribe(
                (products: any[]) => {
                    this.products = products;
                    this.products.forEach(product => {
                        this.ecommerceService.productOrders2.push(new ProductOrder(product, 0));
                    });
                },
                (error) => console.log(error)
            );
    }

    private calculateTotal(products: ProductOrder[]): number {
        let sum = 0;
        products.forEach(value => {
            sum += (value.product.price * value.quantity);
        });
        return sum;
    }
    reset() {
        this.productOrders = [];
        this.loadProducts(0);
        this.ecommerceService.ProductOrders.productOrders = [];
        this.productSelected = false;
    }
}
