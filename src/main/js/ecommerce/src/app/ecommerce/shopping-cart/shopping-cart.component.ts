import {Component, EventEmitter, OnDestroy, OnInit, Output, ViewChild} from '@angular/core';
import {ProductOrders} from '../models/product-orders.model';
import {ProductOrder} from '../models/product-order.model';
import {EcommerceService} from '../services/EcommerceService';
import {Subscription} from 'rxjs/internal/Subscription';
import { faCoffee, faPhone, faShoppingCart} from '@fortawesome/free-solid-svg-icons';
import {Router} from '@angular/router';

@Component({
    selector: 'app-shopping-cart',
    templateUrl: './shopping-cart.component.html',
    styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit, OnDestroy {
    faShoppingCart = faShoppingCart;
    orderFinished: boolean;
    orders: ProductOrders;
    total: number = this.ecommerceService.Total;
    sub: Subscription;

    // tslint:disable-next-line:no-output-on-prefix
    @Output() onOrderFinished: EventEmitter<boolean>;
    constructor(public ecommerceService: EcommerceService, private router: Router) {
        this.total = this.ecommerceService.Total;
        this.orderFinished = false;
        this.onOrderFinished = new EventEmitter<boolean>();
    }

    ngOnInit() {
        this.orders = new ProductOrders();
        this.loadCart();
        this.loadTotal();
    }


    private calculateTotal(products: ProductOrder[]): number {
        let sum = 0;
        products.forEach(value => {
            sum += (value.product.price * value.quantity);
        });
        return sum;
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    finishOrder() {
        this.orderFinished = true;
        this.ecommerceService.Total = this.total;
        this.onOrderFinished.emit(this.orderFinished);
        this.router.navigate([':id/payments']);
    }

    loadTotal() {
        this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
            this.ecommerceService.Total = this.calculateTotal(this.orders.productOrders);
            this.total = this.ecommerceService.Total;
        });
    }

    loadCart() {
        this.sub = this.ecommerceService.ProductOrderChanged.subscribe(() => {
            const productOrder = this.ecommerceService.SelectedProductOrder;
            if (productOrder) {
                this.orders.productOrders.push(new ProductOrder(
                    productOrder.product, productOrder.quantity));
            }
            this.ecommerceService.ProductOrders = this.orders;
            this.orders = this.ecommerceService.ProductOrders;
            this.ecommerceService.Total = this.calculateTotal(this.orders.productOrders);
            this.total = this.ecommerceService.Total;
        });
    }

    reset() {
        this.orderFinished = false;
        this.orders = new ProductOrders();
        this.orders.productOrders = [];
        this.loadTotal();
        this.total = 0;
    }
}
