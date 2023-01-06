import { IMessage } from 'app/shared/model/message.model';
import { IUser } from 'app/shared/model/user.model';
import { IChannel } from 'app/shared/model/channel.model';

export interface IMember {
  id?: number;
  messages?: IMessage[] | null;
  user?: IUser | null;
  channel?: IChannel | null;
}

export const defaultValue: Readonly<IMember> = {};
