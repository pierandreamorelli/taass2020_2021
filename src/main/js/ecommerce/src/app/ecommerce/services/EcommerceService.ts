import {ProductOrder} from '../models/product-order.model';
import {Subject} from 'rxjs/internal/Subject';
import {ProductOrders} from '../models/product-orders.model';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';


@Injectable()
export class EcommerceService {
    private productsUrl = '/api/products';
    private ordersUrl = '/api/orders';
    Urls = ['/api/products', '/api/products/Laptop', '/api/products/Accessories', '/api/products/Component'];

    private productOrder: ProductOrder;
    private orders: ProductOrders = new ProductOrders();

    private productOrderSubject = new Subject();
    private ordersSubject = new Subject();
    private totalSubject = new Subject();
    private _category = 1;
    private _productOrders2: ProductOrder[] = [];
    total: number;
    ss = false;
    valueSource: Subject<boolean> = new Subject();
    ProductOrderChanged = this.productOrderSubject.asObservable();
    OrdersChanged = this.ordersSubject.asObservable();
    TotalChanged = this.totalSubject.asObservable();
    public isLoggedin = false;

    constructor(private http: HttpClient) {
    }

    async getAllProducts() {
        return this.http.get(this.productsUrl);
    }
    getURLIndex(id: number) {
        console.log(id);
        let str = '';
        return str += this.productsUrl + '/id/' + String(id);
    }
    getProductbyID(id: number) {
        return this.http.get(this.getURLIndex(id));
    }
    getCategoryUrl(i: number) {
        return this.http.get(this.Urls[i]);
    }
    saveOrder(order: ProductOrders) {
        return this.http.post(this.ordersUrl, order);
    }

    set SelectedProductOrder(value: ProductOrder) {
        this.productOrder = value;
        this.productOrderSubject.next();
    }

    get SelectedProductOrder() {
        return this.productOrder;
    }

    set ProductOrders(value: ProductOrders) {
        this.orders = value;
        this.ordersSubject.next();
    }

    get ProductOrders() {
        return this.orders;
    }

    get Total() {
        if (this.total > 0) {
            return Math.round(this.total * 100) / 100;
        } else {return 0; }
    }

    set Total(value: number) {
        this.total = value;
        this.totalSubject.next();
    }
    changeTotal(value: number) {
        this.total = value;
        this.totalSubject.next();
    }

    changeFoo(ss: boolean) {
        this.valueSource.next(ss);
    }
    getProductByRange(min: number, max: number, category: number) {
        if (category === 0) {
            return this.http.get(this.Urls[category] + '/' + min + '/-/' + max);
        } else {
            return this.http.get(this.Urls[category] + '/' + min + '/' + max);
        }
    }
    get category(): number {
        return this._category;
    }

    set category(value: number) {
        this._category = value;
    }
    get productOrders2(): ProductOrder[] {
        return this._productOrders2;
    }

    set productOrders2(value: ProductOrder[]) {
        this._productOrders2 = value;
    }
    isLogged() {
        return this.isLoggedin;
    }
}
