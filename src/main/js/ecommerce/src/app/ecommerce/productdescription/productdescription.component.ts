import {Component, OnInit, ViewChild} from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import {Product} from '../models/product.model';
import {EcommerceService} from '../services/EcommerceService';
import {ProductOrder} from '../models/product-order.model';
import {ProductOrders} from '../models/product-orders.model';
import {Subscription} from 'rxjs/internal/Subscription';


@Component({
  selector: 'app-productdescription',
  templateUrl: './productdescription.component.html',
  styleUrls: ['./productdescription.component.css'],
})
export class ProductdescriptionComponent implements OnInit {
    id: number;
    inItems: Product;
    productOrder: ProductOrder;
    orderFinished = false;
    productSelected = false;

    sub: Subscription;
    selectedProductOrder: ProductOrder;
    constructor(private activeRoute: ActivatedRoute, private ecommerceService: EcommerceService) { }
     ngOnInit() {

        this.activeRoute.params.subscribe(
            (params: Params) => {
                this.id = params.id;
            }
        );
         this.loadItem(this.id);
    }

    isProductSelected(product: Product): boolean {
        return this.getProductIndex(product) > -1;
    }
    getProductIndex(product: Product): number {
        return this.ecommerceService.ProductOrders.productOrders.findIndex(
            value => value.product.id === product.id);
    }
    addToCart(order: ProductOrder) {
        this.ecommerceService.SelectedProductOrder = order;
        this.selectedProductOrder = this.ecommerceService.SelectedProductOrder;
        // tslint:disable-next-line:comment-format
        //rimozione
        this.productSelected = true;
    }
    removeFromCart(productOrder: ProductOrder) {
        const index = this.getProductIndex(this.inItems);
        if (index > -1) {
            this.ecommerceService.ProductOrders.productOrders.splice(
                this.getProductIndex(productOrder.product), 1);
        }
        this.ecommerceService.changeTotal(this.calculateTotal(this.ecommerceService.ProductOrders.productOrders));
        this.productSelected = false;
    }

    private calculateTotal(products: ProductOrder[]): number {
        let sum = 0;
        products.forEach(value => {
            sum += (value.product.price * value.quantity);
        });
        return sum;
    }
    loadItem(id: number) {
           this.ecommerceService.getProductbyID(this.id).subscribe((data) => {
               console.log(data);
               this.id = data['id'];
              this.inItems = new Product(data['id'], data['name'], data['price'], data['pictureUrl'], data['category'], data['description']);
              this.productOrder = new ProductOrder(this.inItems, 0);
         } );
     }

}
