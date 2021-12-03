import {Component, OnInit, ViewChild} from '@angular/core';
import {ProductOrders} from '../models/product-orders.model';
import {Subscription} from 'rxjs/internal/Subscription';
import {EcommerceService} from '../services/EcommerceService';
import {ShoppingCartComponent} from '../shopping-cart/shopping-cart.component';

@Component({
    selector: 'app-orders',
    templateUrl: './orders.component.html',
    styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
    orders: ProductOrders;
    total: number;
    paid: boolean;
    sub: Subscription;

    @ViewChild('sc')
    sc: ShoppingCartComponent;

    constructor(public ecommerceService: EcommerceService) {
        this.orders = this.ecommerceService.ProductOrders;
    }

    ngOnInit() {
        this.paid = false;
        this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
            this.orders = this.ecommerceService.ProductOrders;
        });
        this.loadTotal();
    }

    pay() {
        if (this.ecommerceService.isLogged()) {
            this.paid = true;
            this.ecommerceService.saveOrder(this.orders).subscribe();
            this.ecommerceService.ProductOrders.productOrders = [];
            this.ecommerceService.Total = 0;
        } else {
            alert('Per completare l\' acquisto è richiesto il Login');
        }
    }

    loadTotal() {
        this.sub = this.ecommerceService.TotalChanged.subscribe(() => {
            this.total = this.ecommerceService.Total;
        });
    }
}
